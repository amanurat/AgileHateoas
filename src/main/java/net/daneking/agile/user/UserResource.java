package net.daneking.agile.user;

import org.springframework.hateoas.ResourceSupport;

public class UserResource extends ResourceSupport {
	private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(final Integer number) {
		this.number = number;
	}
}
