package pack3;
public class Lab2_2Main {
	 public static void main(String[] args) {
	     SavingsAcc savAcc = new SavingsAcc("Smith", 2000);
	     savAcc.withdraw(1600); 
	     savAcc.withdraw(1000);
	     savAcc.deposit(500);

	     // Create current account
	     CurrentAcc curAcc = new CurrentAcc("Kathy", 3000, 1000);
	     curAcc.withdraw(3500); 
	     curAcc.withdraw(1000); 
	     curAcc.deposit(2000);

	     System.out.println("\nFinal Account Details:");
	     System.out.println(savAcc);
	     System.out.println(curAcc);
	 }
	}