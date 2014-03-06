package net.daneking.agile.iteration;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/iteration")
public class IterationController {
	@Autowired
	IterationResourceAssembler iterationResourceAssembler;

	@RequestMapping(value = "/{number}", method = RequestMethod.GET)
	@ResponseBody
	public HttpEntity<IterationResource> get(@PathVariable final String number) {
		IterationResource iteration = iterationResourceAssembler.toResource(new Iteration(number));
		return new ResponseEntity<IterationResource>(iteration, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> create(@RequestBody final IterationResource iteration) {
		// save
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(methodOn(getClass()).get(iteration.getNumber())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
