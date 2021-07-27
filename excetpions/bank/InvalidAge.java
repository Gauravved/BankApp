package excetpions.bank;

public class InvalidAge extends Exception{
	private int age;

	public InvalidAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "You are a minor  [age=" + age + "] < 18";
	}
	
}
