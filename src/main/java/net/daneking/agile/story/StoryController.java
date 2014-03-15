package net.daneking.agile.story;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

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
@RequestMapping("/stories")
public class StoryController {
	@Autowired
	private StoryResourceAssembler storyResourceAssembler;
	@Autowired
	StoryRepository repository;

	@RequestMapping("/{number}")
	@ResponseBody
	public HttpEntity<StoryResource> get(@PathVariable final Integer number) {
		// lookup
		Story story = repository.findById(number);
		StoryResource storyResource = storyResourceAssembler.toResource(story);
		return new ResponseEntity<StoryResource>(storyResource, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> create(@RequestBody final StoryResource story) {
		// save
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(methodOn(getClass()).get(story.getNumber())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = { "/iteration/{iterationNumber}" }, method = RequestMethod.GET)
	@ResponseBody
	public List<StoryResource> findStories(@PathVariable("iterationNumber") final Integer iterationNumber) {
		return storyResourceAssembler.toResources(repository.findStoriesBy(iterationNumber));
	}

}
