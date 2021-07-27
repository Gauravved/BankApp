package excetpions.bank;
import packages.*;
import java.util.LinkedList;
public class Exceptions {

	public void handling(String mob, double acBal) throws InvalidAccBal {
		try {
			if (acBal < 1000) {
				throw new InvalidAccBal(acBal);
			}
		} catch (InvalidAccBal e) {
			throw e;
		}

	}

	public void ageHandle(int age) throws InvalidAge {
		try {
			if (age < 18) {
				throw new InvalidAge(age);
			}
		} catch (InvalidAge e) {
			throw e;
		}

	}

	public void mobile(String mob,LinkedList<Customer> cust) throws Exception {
		try {
			if (mob.length() != 10) {
				throw new InvalidMobile();
			}
			long mble = Long.parseLong(mob);
			for(int i=0;i<cust.size();i++) {
				if(cust.get(i).getCustMob().equals(mob)) {
					throw new InvalidMobile();
				}
			}
		} catch (Exception e) {
			throw e;
		}

	}

	public void nameexcep(String name) throws InvalidName {
		try {
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {

				} else {
					throw new InvalidName(name);
				}
			}
		} catch (InvalidName e) {
			throw e;
		}

	}

}
