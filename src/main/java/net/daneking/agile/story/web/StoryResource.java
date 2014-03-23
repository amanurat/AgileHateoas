package net.daneking.agile.story.web;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.springframework.hateoas.ResourceSupport;

public class StoryResource extends ResourceSupport {
	private String name;
	private Integer number;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
