package pack3;

//Account class
class Lab2_2 {
 private long accNum;
 protected double bal;
 private String holder;
 private static long nextAccNum = 100000;

 public Lab2_2(String h, double b) {
     holder = h;
     bal = b;
     accNum = nextAccNum++;
 }

 public void deposit(double amt) {
     bal += amt;
 }

 public boolean withdraw(double amt) {
     if (amt > 0 && bal - amt >= 0) {
         bal -= amt;
         return true;
     }
     return false;
 }

 public double getBal() {
     return bal;
 }

 public String toString() {
     return "AccNum: " + accNum + ", Holder: " + holder + ", Balance: INR " + bal;
 }
}

//Savings Account subclass
class SavingsAcc extends Lab2_2 {
 private final double minBal = 500;

 public SavingsAcc(String h, double b) {
     super(h, b);
 }

 @Override
 public boolean withdraw(double amt) {
     if (amt > 0 && (bal - amt) >= minBal) {
         bal -= amt;
         return true;
     }
     System.out.println("Withdraw failed: Minimum balance of INR " + minBal + " must be maintained.");
     return false;
 }
}

//Current Account subclass
class CurrentAcc extends Lab2_2 {
 private double odLimit;

 public CurrentAcc(String h, double b, double limit) {
     super(h, b);
     odLimit = limit;
 }

 @Override
 public boolean withdraw(double amt) {
     if (amt > 0 && (bal - amt) >= -odLimit) {
         bal -= amt;
         return true;
     }
     System.out.println("Withdraw failed: Overdraft limit of INR " + odLimit + " exceeded.");
     return false;
 }
}