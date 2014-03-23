package net.daneking.agile.user;

public class User {
	private final String firstName;
	private final String lastName;

	private User(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
