package packages;
import java.util.Date;

public class Transaction {
	private int trno;
	private Date trDate;
	private double amt;
	private String tranType;

	public Transaction(int trno, Date trDate, double amt, String tranType) {
		this.trno = trno;
		this.trDate = trDate;
		this.amt = amt;
		this.tranType = tranType;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public int getTrno() {
		return trno;
	}

	public void setTrno(int trno) {
		this.trno = trno;
	}

	public Date getTrDate() {
		return trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

}
