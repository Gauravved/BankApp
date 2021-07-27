package packages;
import java.util.*;
import excetpions.bank.*;
public class BankManager {
	Scanner sc = new Scanner(System.in);

	public Customer Create(LinkedList<Customer> c) {
		Exceptions ex = new Exceptions();
		System.out.println("Enter Name of the customer:");
		String name = sc.next();
		boolean bool = true;
		do {
			try {
				ex.nameexcep(name);
				bool = false;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Please re-enter the name:");
				name = sc.next();
				bool = true;
			}
		} while (bool == true);
		char ch = ' ';
		for (int j = name.length() + 1; j < 10; j++) {
			name = name.substring(0, name.length()) + ch;
		}
		System.out.println("Enter the age of the customer:");
		int age = sc.nextInt();
		System.out.println("Enter the Mobile:");
		String mob = sc.next();
		boolean b = true;
		do {
			try {
				ex.mobile(mob,c);
				b = false;
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Re-Enter your mobile number:");
				mob = sc.next();
				b = true;
			}
		} while (b == true);
		System.out.println("Enter the city you live in:");
		String city = sc.next();
		do {
			try {
				ex.nameexcep(city);
				bool = false;
			} catch (Exception ee) {
				System.out.println(ee);
				System.out.println("Please re-enter the name:");
				city = sc.next();
				bool = true;
			}
		} while (bool == true);
		for (int j = city.length() + 1; j < 10; j++) {
			city = city.substring(0, city.length()) + ch;
		}
		System.out.println("Enter the State your city is in:");
		String state = sc.next();
		do {
			try {
				ex.nameexcep(state);
				bool = false;
			} catch (Exception ee) {
				System.out.println(ee);
				System.out.println("Please re-enter the name:");
				state = sc.next();
				bool = true;
			}
		} while (bool == true);
		for (int j = state.length() + 1; j < 10; j++) {
			state = state.substring(0, state.length()) + ch;
		}
		System.out.println("Enter your pincode:");
		long pincode = sc.nextLong();
		Address add = new Address(city, state, pincode);
		System.out.println("Enter the account number:");
		int acNo = sc.nextInt();
		for (int i = 0; i < c.size(); i++) {
			while (c.get(i).getAcc().getAccNo() == acNo) {
				System.out.println("Please enter a unique account number!! :");
				acNo = sc.nextInt();
			}
		}
		System.out.println("Enter Account balance:");
		double acBal = sc.nextDouble();
		String acType;
		try {
			ex.handling(mob, acBal);
		} catch (Exception e) {
			System.out.println(e);
			while (acBal < 1000) {
				System.out.println("Please re-enter the balance you want yo keep in your account:");
				acBal = sc.nextDouble();
			}
		}
		try {
			ex.ageHandle(age);
			System.out.println("Enter the account type:  (1> Saving,  2> Current): ");
			int m = sc.nextInt();
			if (m == 1) {
				acType = "Saving";
				Savings save = new Savings(acNo, acType, acBal, 1.5f);
				Customer cust = new Customer(name, age, mob, save, add);
				return cust;
			} else if (m == 2) {
				acType = "Current";
				System.out.println("Enter your company name:");
				String company = sc.next();
				Current cur = new Current(acNo, acType, acBal, company);
				Customer cust = new Customer(name, age, mob, cur, add);
				return cust;
			} else {
				System.out.println("Invalid choice!. Hence by default account type is: Saving");
				acType = "Saving";
				Savings save = new Savings(acNo, acType, acBal, 1.5f);
				Customer cust = new Customer(name, age, mob, save, add);
				return cust;
			}
		} catch (InvalidAge e) {
			System.out.println(e);
			System.out.println("As you are minor your default account type is Joint account:");
			acType = "Joint";
			String nme = "";
			boolean bb = false;
			int accNo = 0;
			int flag = 0;
			Customer cust = null;
			while (flag == 0) {
				System.out.println("Enter the name of the person for joint account:");
				nme = sc.next();
				bool = true;
				do {
					try {
						ex.nameexcep(nme);
						bool = false;
					} catch (Exception ee) {
						System.out.println(ee);
						System.out.println("Please re-enter the name:");
						nme = sc.next();
						bool = true;
					}
				} while (bool == true);
				ch = ' ';
				for (int j = nme.length() + 1; j < 10; j++) {
					nme = nme.substring(0, nme.length()) + ch;
				}
				System.out.println("Enter there account number:");
				accNo = sc.nextInt();
				flag = 1;
				for (int i = 0; i < c.size(); i++) {
					if (accNo == c.get(i).getAcc().getAccNo()) {
						if (c.get(i).getAge() < 18) {
							System.out.println(
									"The age of this account holder is also less than 18. Hence joint account with this person not possible!!!");
							flag = 0;
						} else {
							jointAcc jnt = new jointAcc(acNo, acType, acBal, nme, accNo);
							cust = new Customer(name, age, mob, jnt, add);
							flag = 1;
							bb = true;
						}
					}
				}
			}
			if (!bb) {
				System.out.println("This account does not exist.. Do you want to create this account to?[y/n]:");
				char cc = sc.next().charAt(0);
				if (cc == 'Y' || cc == 'y') {
					jointAcc jnt = new jointAcc(acNo, acType, acBal, nme, accNo);
					cust = new Customer(name, age, mob, jnt, add);
				}
			}
			return (cust);
		}
	}

	public Customer Joint(String name, int accno, LinkedList<Customer> cc) {
		System.out.println("Age of this customer should compulsorily be above 18!!");
		System.out.println("This account is being created for " + name
				+ " and account number will compulsorily will be " + accno + " so please enter the same details");
		Customer c = null;
		c = Create(cc);
		c.getAcc().setAccNo(accno);
		c.setName(name);
		try {
			if (c.getAge() < 18) {
				throw new InvalidAge(c.getAge());
			}
		} catch (InvalidAge e) {
			System.out.println("This account can't be created hence it will be discarded!!!!");
			c = null;
		}
		return c;
	}

	public void Display(LinkedList<Customer> cust) {
		if (!cust.isEmpty()) {
			int i = 0;
			System.out.println(
					"\nSrno\t Name \t\tMobile number\t City \t\tState \t\tPincode \tAccount number \t Account type\t Account balance ");
			while (cust.size() > i) {
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------");
				System.out.print((i + 1) + "\t" + cust.get(i).getName() + "\t" + cust.get(i).getCustMob() + "\t"
						+ cust.get(i).getAddr().getCity() + "\t" + cust.get(i).getAddr().getState() + "\t"
						+ cust.get(i).getAddr().getPincode() + "\t\t");
				if (cust.get(i).getAcc() instanceof Savings) {
					Savings save = (Savings) cust.get(i).getAcc();
					Acct(save);
				} else if (cust.get(i).getAcc() instanceof Current) {
					Current cur = (Current) cust.get(i).getAcc();
					Acct(cur);
				} else {
					jointAcc jnt = (jointAcc) cust.get(i).getAcc();
					Acct(jnt);
				}
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------");
				i++;
			}
		} else {
			System.out.println("No entries done yet!!");
		}
	}

	public void Search(LinkedList<Customer> cust, int s) {
		if (!cust.isEmpty()) {
			boolean b = false;
			for (int i = 0; i < cust.size(); i++) {
				if (s == cust.get(i).getAcc().getAccNo()) {
					System.out.println(
							"\nSrno\t Name \t\tMobile number\t City \t\tState \t\tPincode \tAccount number \t Account type\t Account balance ");
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");
					System.out.print((i + 1) + "\t" + cust.get(i).getName() + "\t" + cust.get(i).getCustMob() + "\t"
							+ cust.get(i).getAddr().getCity() + "\t" + cust.get(i).getAddr().getState() + "\t"
							+ cust.get(i).getAddr().getPincode() + "\t\t");
					if (cust.get(i).getAcc() instanceof Savings) {
						Savings save = (Savings) cust.get(i).getAcc();
						Acct(save);
					} else if (cust.get(i).getAcc() instanceof Current) {
						Current cur = (Current) cust.get(i).getAcc();
						Acct(cur);
					} else {
						jointAcc jnt = (jointAcc) cust.get(i).getAcc();
						Acct(jnt);
					}
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");
					b = true;
				}
			}
			if (!b) {
				System.out.println("This account does not exist!!");
			}
		} else {
			System.out.println("No entries done yet!!");
		}
	}

	public void Acct(Account acc) {
		System.out.println(acc);
	}

	public int WithDraw(LinkedList<Customer> cust, int acno, int m) {
		if (!cust.isEmpty()) {
			boolean b = false;
			for (int i = 0; i < cust.size(); i++) {
				if (acno == cust.get(i).getAcc().getAccNo()) {
					b = true;
					int k = 0;
					System.out.println("Enter your password:");
					String pass = sc.next();
					while (!pass.equals(cust.get(i).getPass()) && k < 3) {
						System.out.println("Re-enter your password it is wrong:");
						pass = sc.next();
						k++;
					}
					if (k < 3) {
						System.out.println("Enter the amount you want to withdraw:");
						double amt = sc.nextDouble();
						if (cust.get(i).getAcc().getAccBal() - amt < 1000) {
							System.out.println(
									"1000Rs. must be your minimum balance but after this transaction balance will be "
											+ (cust.get(i).getAcc().getAccBal() - amt)
											+ " Rs. Hence this transaction is not possible !!");
							m--;
						} else {
							cust.get(i).getAcc().setAccBal(cust.get(i).getAcc().getAccBal() - amt);
							Transaction t = new Transaction(m, new Date(), amt, "Withdraw");
							cust.get(i).getTr().add(t);
							System.out.println(
									"\nSrno\t Name \t\tMobile number\t City \t\tState \t\tPincode \tAccount number \t Account type\t Account balance ");
							System.out.println(
									"-----------------------------------------------------------------------------------------------------------------------------------------");
							System.out.println((i + 1) + "\t" + cust.get(i).getName() + "\t" + cust.get(i).getCustMob()
									+ "\t" + cust.get(i).getAddr().getCity() + "\t" + cust.get(i).getAddr().getState()
									+ "\t" + cust.get(i).getAddr().getPincode() + "\t\t"
									+ cust.get(i).getAcc().getAccNo() + "\t\t" + cust.get(i).getAcc().getAccType()
									+ "\t\t" + cust.get(i).getAcc().getAccBal());
							System.out.println(
									"-----------------------------------------------------------------------------------------------------------------------------------------");

						}
						System.out.println("Do you want to you transaction history? [y/n] :");
						String c = sc.next();
						if ((c.charAt(0) == 'y' || c.charAt(0) == 'Y')) {
							if (cust.get(i).getTr().isEmpty()) {
								System.out.println("No transaction history!!");
								b = true;
								break;
							}
							System.out.println(
									"----------------------------------- Transaction history ---------------------------");
							System.out.println("Number\t Type\t\tAmount \t\tDate");
							for (int j = 0; j < cust.get(i).getTr().size(); j++) {
								System.out.println(cust.get(i).getTr().get(j).getTrno() + "\t"
										+ cust.get(i).getTr().get(j).getTranType() + "\t"
										+ cust.get(i).getTr().get(j).getAmt() + "\t\t"
										+ cust.get(i).getTr().get(j).getTrDate());
							}
						}
					} else {
						System.out.println("Transaction Failed !! Try after some time");
						break;
					}
				}
			}
			if (!b) {
				System.out.println("This account number does not exist!!");
			}
		} else {
			System.out.println("No entries done yet!!");
			m--;
		}
		return m;
	}

	public int Deposit(LinkedList<Customer> cust, int acno, int m) {
		if (!cust.isEmpty()) {
			boolean b = false;
			for (int i = 0; i < cust.size(); i++) {
				if (acno == cust.get(i).getAcc().getAccNo()) {
					b = true;
					int k = 0;
					System.out.println("Enter your password:");
					String pass = sc.next();
					while (!pass.equals(cust.get(i).getPass()) && k < 3) {
						System.out.println("Re-enter your password it is wrong:");
						pass = sc.next();
						k++;
					}
					if (k < 3) {
						System.out.println("Enter the amount you want to deposit:");
						double amt = sc.nextDouble();
						cust.get(i).getAcc().setAccBal(cust.get(i).getAcc().getAccBal() + amt);
						Transaction t = new Transaction(m, new Date(), amt, "Deposit   ");
						cust.get(i).getTr().add(t);
						System.out.println(
								"\nSrno\t Name \t\tMobile number\t City \t\tState \t\tPincode \tAccount number \t Account type\t Account balance ");
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println((i + 1) + "\t" + cust.get(i).getName() + "\t" + cust.get(i).getCustMob()
								+ "\t" + cust.get(i).getAddr().getCity() + "\t" + cust.get(i).getAddr().getState()
								+ "\t" + cust.get(i).getAddr().getPincode() + "\t\t" + cust.get(i).getAcc().getAccNo()
								+ "\t\t" + cust.get(i).getAcc().getAccType() + "\t\t"
								+ cust.get(i).getAcc().getAccBal());
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------");

						System.out.println("Do you want to you transaction history? [y/n] :");
						String c = sc.next();
						if ((c.charAt(0) == 'y' || c.charAt(0) == 'Y')) {
							if (cust.get(i).getTr().isEmpty()) {
								System.out.println("No transaction history!!");
								b = true;
								break;
							}
							System.out.println(
									"----------------------------------- Transaction history ---------------------------");
							System.out.println("Number\t Type\t\tAmount \t\tDate");
							for (int j = 0; j < cust.get(i).getTr().size(); j++) {
								System.out.println(cust.get(i).getTr().get(j).getTrno() + "\t"
										+ cust.get(i).getTr().get(j).getTranType() + "\t"
										+ cust.get(i).getTr().get(j).getAmt() + "\t\t"
										+ cust.get(i).getTr().get(j).getTrDate());
							}
						}
					} else {
						System.out.println("Transaction Failed !! Try after some time");
						break;
					}
				}
			}
			if (!b) {
				System.out.println("This account number does not exist!!");
			}
		} else {
			System.out.println("No entries done yet!!");
			m--;
		}
		return m;
	}

	public void Transhist(LinkedList<Customer> cust, int acno) {
		if (!cust.isEmpty()) {
			boolean b = false;
			for (int i = 0; i < cust.size(); i++) {
				if (cust.get(i).getAcc().getAccNo() == acno) {
					b = true;
					if (cust.get(i).getTr().isEmpty()) {
						System.out.println("No transaction history of this account!!!");
						break;
					} else {
						System.out.println(
								"----------------------------------- Transaction history ---------------------------");
						System.out.println("Number\t Type\t\tAmount \t\tDate");
						for (int j = 0; j < cust.get(i).getTr().size(); j++) {
							System.out.println(cust.get(i).getTr().get(j).getTrno() + "\t"
									+ cust.get(i).getTr().get(j).getTranType() + "\t"
									+ cust.get(i).getTr().get(j).getAmt() + "\t\t"
									+ cust.get(i).getTr().get(j).getTrDate());
						}
					}
				}
			}
			if (!b) {
				System.out.println("This account is not present !!!");
			}
		} else {
			System.out.println("No entries done yet!!");
		}
	}

	public void rem(LinkedList<Customer> cust) {
		if (!cust.isEmpty()) {
			System.out.println("Enter the account number you want to remove:");
			int ac = sc.nextInt();
			int flag = 0;
			for (int i = 0; i < cust.size(); i++) {
				if (cust.get(i).getAcc().getAccNo() == ac) {
					flag = 1;
					System.out.println(
							"\nSrno\t Name \t\tMobile number\t City \t\tState \t\tPincode \tAccount number \t Account type\t Account balance ");
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");
					System.out.print((i + 1) + "\t" + cust.get(i).getName() + "\t" + cust.get(i).getCustMob() + "\t"
							+ cust.get(i).getAddr().getCity() + "\t" + cust.get(i).getAddr().getState() + "\t"
							+ cust.get(i).getAddr().getPincode() + "\t\t");
					if (cust.get(i).getAcc() instanceof Savings) {
						Savings save = (Savings) cust.get(i).getAcc();
						Acct(save);
					} else if (cust.get(i).getAcc() instanceof Current) {
						Current cur = (Current) cust.get(i).getAcc();
						Acct(cur);
					} else {
						jointAcc jnt = (jointAcc) cust.get(i).getAcc();
						Acct(jnt);
					}
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------");

					System.out.println("Do you want to delete this account permanently? [y/n]:");
					char ch = sc.next().charAt(0);
					if (ch == 'Y' || ch == 'y') {
						cust.remove(i);
					}
				}
			}
			if (flag == 0) {
				System.out.println("This account number does not exist!!!!");
			}
		} else {
			System.out.println("No entries done yet!!");
		}

	}

}
