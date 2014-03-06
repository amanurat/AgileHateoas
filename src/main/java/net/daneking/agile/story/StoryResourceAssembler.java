package net.daneking.agile.story;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import net.daneking.agile.iteration.IterationController;

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
		resource.add(linkTo(methodOn(IterationController.class).get("2")).withRel("iteration"));
		return resource;
	}

	@Override
	protected StoryResource instantiateResource(final Story entity) {
		StoryResource instantiateResource = super.instantiateResource(entity);
		instantiateResource.setName(entity.getName());
		instantiateResource.setNumber(entity.getNumber());
		return instantiateResource;
	}
}
