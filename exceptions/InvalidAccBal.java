package exceptions;

public class InvalidAccBal extends Exception{
	private double accbal;

	public InvalidAccBal(double accbal) {
		this.accbal = accbal;
	}
	public String toString() {
		return "Your balance must be atleast 1000 rs. [accbal=" + accbal + " <1000]";
	}
	
}
