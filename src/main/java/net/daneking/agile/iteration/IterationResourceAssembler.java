package net.daneking.agile.iteration;

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
		// link stories after create get all stories by iteration
		return resource;

	}

}
