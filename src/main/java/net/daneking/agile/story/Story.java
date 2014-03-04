package net.daneking.agile.story;

public class Story {
	private String name;
	private String number;

	public Story(final String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}
}
