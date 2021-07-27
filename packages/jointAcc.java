package packages;
public class jointAcc extends Account{
		private String Name;
		private int acNo;
		public jointAcc(int accNo, String accType, double accBal, String name, int acNo) {
			super(accNo, accType, accBal);
			Name = name;
			this.acNo = acNo;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getAcNo() {
			return acNo;
		}
		public void setAcNo(int acNo) {
			this.acNo = acNo;
		}

		public String toString() {
			return getAccNo() + "\t\t"+getAccType() + "\t\t" + getAccBal()+" \t\tName: "+getName()+"\tAccount no:"+getAcNo();
		}
}
