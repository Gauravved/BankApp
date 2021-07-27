package packages;
public class Savings  extends Account{
	private float interrate;

	public Savings(int accNo, String accType, double accBal, float interrate) {
		super(accNo, accType, accBal);
		this.interrate = interrate;
	}

	public float getInterrate() {
		return interrate;
	}

	public void setInterrate(int interrate) {
		this.interrate = interrate;
	}

	public String toString() {
		return getAccNo() + "\t\t"+getAccType() + "\t\t" + getAccBal()+" \tInterest: "+getInterrate();
	}
	
}
