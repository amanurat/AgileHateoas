package net.daneking.agile.iteration;

import org.springframework.hateoas.ResourceSupport;

public class IterationResource extends ResourceSupport {
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

}
