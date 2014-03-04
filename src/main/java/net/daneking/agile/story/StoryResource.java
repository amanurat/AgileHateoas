package net.daneking.agile.story;

import org.springframework.hateoas.ResourceSupport;

public class StoryResource extends ResourceSupport {
	private final String name;
	private final String number;
	private String iteration;

	public StoryResource() {
		this.name = "";
		this.number = "";

	}

	public StoryResource(final String name, final String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getIteration() {
		return iteration;
	}

}
