package exceptions;

public class InvalidAge extends Exception{
	private int age;

	public InvalidAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "You are a minor  [age=" + age + "] < 18";
	}
	
}
