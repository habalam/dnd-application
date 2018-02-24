package sk.dnd.domain.character.support;

public class Height {

	public Height() {}

	public Height(int feets, int inches) {
		this.feets = feets;
		this.inches = inches;
	}
	private int feets;

	private int inches;

	public int getFeets() {
		return feets;
	}

	public void setFeets(int feets) {
		this.feets = feets;
	}

	public int getInches() {
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}
}
