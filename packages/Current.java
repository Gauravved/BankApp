package packages;
public class Current extends Account{
	private String company;

	public Current(int accNo, String accType, double accBal, String company) {
		super(accNo, accType, accBal);
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String toString() {
		return getAccNo() + "\t\t"+getAccType() + "\t\t" + getAccBal()+" \tCompany: "+getCompany();
	}
}
