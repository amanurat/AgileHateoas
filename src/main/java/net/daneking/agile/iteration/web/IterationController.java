package net.daneking.agile.iteration.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import net.daneking.agile.iteration.Iteration;
import net.daneking.agile.iteration.IterationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/iteration", produces = { MediaType.APPLICATION_JSON_VALUE,
		IterationController.APPLICATION_HAL_JSON_VALUE })
public class IterationController {
	static final String APPLICATION_HAL_JSON_VALUE = "application/hal+json";
	@Autowired
	IterationResourceAssembler iterationResourceAssembler;
	@Autowired
	IterationRepository repository;

	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<IterationResource> get(@PathVariable final Integer number) {
		Iteration iteration = repository.findIterationBy(number);
		IterationResource resource = iterationResourceAssembler.toResource(iteration);
		return new ResponseEntity<IterationResource>(resource, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> create(@RequestBody final IterationResource iteration) {
		// save
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(methodOn(getClass()).get(iteration.getNumber())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<IterationResource> findByStory(@RequestParam(value = "story") final Integer storyNumber) {
		Integer number = 4;
		IterationResource iteration = iterationResourceAssembler.toResource(new Iteration(number));
		return new ResponseEntity<IterationResource>(iteration, HttpStatus.OK);
	}

	@RequestMapping(value = "/{number}/stories", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<IterationResource> getAllStories() {
		Integer number = 4;
		IterationResource iteration = iterationResourceAssembler.toResource(new Iteration(number));
		return new ResponseEntity<IterationResource>(iteration, HttpStatus.OK);
	}

}
