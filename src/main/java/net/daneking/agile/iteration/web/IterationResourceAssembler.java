package net.daneking.agile.iteration.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import net.daneking.agile.iteration.Iteration;
import net.daneking.agile.story.web.StoryController;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class IterationResourceAssembler extends ResourceAssemblerSupport<Iteration, IterationResource> {

	public IterationResourceAssembler() {
		super(IterationController.class, IterationResource.class);
	}

	@Override
	public IterationResource toResource(final Iteration iteration) {
		IterationResource resource = createResourceWithId(iteration.getNumber(), iteration);
		resource.add(linkTo(methodOn(StoryController.class).findStories(iteration.getNumber())).withRel("stories"));
		return resource;

	}

	@Override
	protected IterationResource createResourceWithId(final Object id, final Iteration entity) {
		IterationResource createResourceWithId = super.createResourceWithId(id, entity);
		createResourceWithId.setNumber(Integer.valueOf(id.toString()));
		return createResourceWithId;
	}
}
