package packages;
import java.util.*;

public class Customer {
	private String name;
	private int age;
	private String custMob;
	private Account acc;
	private Address addr;
	private LinkedList<Transaction> tr = new LinkedList<Transaction>();
	private String pass;

	public Customer(String name,int age, String custMob, Account acc, Address addr) {
		this.name = name;
		this.age=age;
		this.custMob = custMob;
		this.acc = acc;
		this.addr = addr;
		this.pass = this.name.substring(0, 3) + Integer.toString(acc.getAccNo()).substring(0, 3);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustMob() {
		return custMob;
	}

	public void setCustMob(String custMob) {
		this.custMob = custMob;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public LinkedList<Transaction> getTr() {
		return tr;
	}

	public void setTr(LinkedList<Transaction> tr) {
		this.tr = tr;
	}

}
