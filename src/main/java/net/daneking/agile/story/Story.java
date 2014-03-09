package net.daneking.agile.story;

public class Story {
	private String name;
	private Integer number;

	public Story(final Integer number) {
		this.number = number;
	}

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
}
