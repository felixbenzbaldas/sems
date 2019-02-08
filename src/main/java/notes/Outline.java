package notes;

public class Outline implements MyObject {

	private String name;
	
	public Outline(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toStringBig() {
		return this.toString();
	}

	public String getName() {
		return name;
	}
}
