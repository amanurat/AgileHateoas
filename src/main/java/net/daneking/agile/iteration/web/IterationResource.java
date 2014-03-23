package net.daneking.agile.iteration.web;

import org.springframework.hateoas.ResourceSupport;

public class IterationResource extends ResourceSupport {
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}

}
