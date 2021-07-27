package excetpions.bank;

public class InvalidName extends Exception {
	private String name;

	public InvalidName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Your Name is Invalid [name=" + name + "]";
	}
	
}
