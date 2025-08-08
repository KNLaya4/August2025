package pack3;


class InvalidAgeException extends Exception {
 public InvalidAgeException(String message) {
     super(message);
 }
}

class Person1 {
 private String name;
 private int age;

 public Person1(String name, int age) throws InvalidAgeException {
     if (age <= 15) {
         throw new InvalidAgeException("Age must be above 15. Provided: " + age);
     }
     this.name = name;
     this.age = age;
 }

 public String getName() {
     return name;
 }
 public void setName(String name) {
     this.name = name;
 }
 public int getAge() {
     return age;
 }
 public void setAge(int age) {
     this.age = age;
 }
}

class Account1 {
 private long accNum;
 private double balance = 500;
 private Person1 accHolder;

 public Account1(long accNum, double balance, Person1 p1) {
     this.accNum = accNum;
     this.balance = balance;
     this.accHolder = p1;
 }

 @Override
 public String toString() {
     return "Account Number: " + accNum +
            "\nBalance: " + balance +
            "\nAccount Holder: " + accHolder.getName();
 }

 public long getAccNum() {
     return accNum;
 }

 public void setAccNum(long accNum) {
     this.accNum = accNum;
 }

 public Person1 getAccHolder() {
     return accHolder;
 }

 public void setAccHolder(Person1 accHolder) {
     this.accHolder = accHolder;
 }

 public void setBalance(double balance) {
     this.balance = balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount < (balance - 500)) {
         balance -= amount;
         return true;
     }
     return false;
 }

 public double getBalance() {
     return balance;
 }
}

public class Lab3_2 {
 public static void main(String[] args) {
     try {
         Person1 p1 = new Person1("Smith", 23);
         Person1 p2 = new Person1("Kathy", 22);
         

         Account1 a1 = new Account1(1001, 2000, p1);
         Account1 a2 = new Account1(1002, 3000, p2);

         a1.setBalance(2000);
         a2.withdraw(2000);

         System.out.println(a1.getAccNum() + " Account has Balance : " + a1.getBalance());
         System.out.println(a2.getAccNum() + " Account has Balance : " + a2.getBalance());
         System.out.println(a1);
         System.out.println(a2);
     } catch (InvalidAgeException e) {
         System.out.println("Error creating person: " + e.getMessage());
     }
 }
}