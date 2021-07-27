package packages;
public class Account {
	protected int accNo;
	protected String accType;
	protected double accBal;
	public Account(int accNo, String accType, double accBal) {
		this.accNo = accNo;
		this.accType = accType;
		this.accBal = accBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public double getAccBal() {
		return accBal;
	}
	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}
	
}
