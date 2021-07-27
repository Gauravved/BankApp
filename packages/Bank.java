package packages;
import java.util.*;

public class Bank {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankManager bm = new BankManager();
		LinkedList<Customer> cust = new LinkedList<Customer>();
		int ch = 0, m = 10, cnt = 0;
		do {
			System.out.println("\n1> Create \n2> Display \n3> Search \n4> Transaction \n5> Remove Account \n6> Exit \nEnter your choice:");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("How many accounts you want to create? :");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					Customer custom = bm.Create(cust);
					if (custom != null) {
						cust.add(custom);
						boolean b = false;
						if (cust.get(cnt).getAge() < 18) {						
							jointAcc ac = (jointAcc) cust.get(cnt).getAcc();
							for (int j = 0; j < cust.size(); j++) {
								if (ac.getAcNo() == cust.get(j).getAcc().getAccNo()) {
									b = true;
								}
							}
							if (!b) {
								cust.add(bm.Joint(ac.getName(), ac.getAcNo(), cust));
								cnt++;
							}
							if (cust.get(cnt) == null) {
								cust.remove(cnt);
								cnt--;
								cust.remove(cnt);
								cnt--;
							}
						}
						cnt++;
					}
				}
				break;
			case 2:
				bm.Display(cust);
				break;
			case 3:
				System.out.println("Enter the account number :");
				int s = sc.nextInt();
				bm.Search(cust, s);
				break;
			case 4:
				System.out.println("\n\t1> Withdrawl \n\t2> Deposit \n\t3> Transaction history \nEnter your choice:");
				int ch2 = sc.nextInt();
				switch (ch2) {
				case 1:
					System.out.println("Enter the Account number:");
					s = sc.nextInt();
					m = bm.WithDraw(cust, s, m);
					m++;
					break;
				case 2:
					System.out.println("Enter the Account number:");
					s = sc.nextInt();
					m = bm.Deposit(cust, s, m);
					m++;
					break;
				case 3:
					System.out.println("Enter the Account number:");
					s = sc.nextInt();
					bm.Transhist(cust, s);
					break;
				default:
					System.out.println("Invalid choice!!");
				}
				break;
			case 5:
				bm.rem(cust);
				break;
			case 6: 
				break;
			default:
				System.out.println("Invalid choice!!");
			}
		} while (ch != 6);
		System.out.println(
				"---------------------------------- Thank you for choosing our bank--------------------------------------------");
		sc.close();
	}

}
