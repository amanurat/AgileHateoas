package net.daneking.agile.story;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.hateoas.ResourceSupport;

public class StoryResource extends ResourceSupport {
	private String name;
	private String number;

	public void setName(final String name) {
		this.name = name;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	private String iteration;

	public StoryResource() {
		this.name = "";
		this.number = "";

	}

	public void setIteration(final String iteration) {
		this.iteration = iteration;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((iteration == null) ? 0 : iteration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		StoryResource rhs = (StoryResource) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(number, rhs.number).isEquals();
	}

}
