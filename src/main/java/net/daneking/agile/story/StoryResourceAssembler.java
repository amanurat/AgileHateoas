package net.daneking.agile.story;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class StoryResourceAssembler extends ResourceAssemblerSupport<Story, StoryResource> {

	public StoryResourceAssembler() {
		super(StoryController.class, StoryResource.class);
	}

	@Override
	public StoryResource toResource(final Story story) {
		StoryResource resource = createResourceWithId(story.getNumber(), story);
		// resource.add(linkTo(methodOn(StoryController.class).get(story.getNumber())).withSelfRel());
		return resource;
	}
}
