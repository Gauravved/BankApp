package excetpions.bank;

public class InvalidAccBal extends Exception{
	private double accbal;

	public InvalidAccBal(double accbal) {
		this.accbal = accbal;
	}

	@Override
	public String toString() {
		return "Your balance must be atleast 1000 rs. [accbal=" + accbal + " <1000]";
	}
	
}
