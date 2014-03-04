package net.daneking.agile.story;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/story")
public class StoryController {

	private static final String TEMPLATE = "Story - %s!";

	@RequestMapping("/{number}")
	@ResponseBody
	public HttpEntity<StoryResource> get(@PathVariable("number") final String number) {
		StoryResource story = new StoryResource(String.format(TEMPLATE, number), number);
		story.add(linkTo(methodOn(StoryController.class).get(number)).withSelfRel());
		return new ResponseEntity<StoryResource>(story, HttpStatus.OK);
	}
}
