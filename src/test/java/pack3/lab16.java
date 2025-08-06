    package pack3;

public class lab16 {

    public static void main(String[] args) {
        Person smith = new Person("Smith", 29);
        Person kathy = new Person("Kathy", 37);

        Account smithAccount = new Account(2000, smith);
        Account kathyAccount = new Account(3000, kathy);

        smithAccount.deposit(2000);
        kathyAccount.withdraw(2000);

        System.out.println("Smith's Account: " + smithAccount.getBalance());
        System.out.println("Kathy's Account: " + kathyAccount.getBalance());

        System.out.println(smithAccount);
        System.out.println(kathyAccount);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
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

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Account {
    private static int accCounter = 1000;
    private int accNum;
    private double balance;
    private Person accHolder;

    public Account(double balance, Person accHolder) {
        this.accNum = accCounter++;
        this.balance = balance;
        this.accHolder = accHolder;
    }

    public int getAccNum() {
        return accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
        }
    }

    public Person getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(Person accHolder) {
        this.accHolder = accHolder;
    }

    public String toString() {
        return "Account Number: " + accNum + ", Balance: " + balance + ", " + accHolder;
        
       
                
            }
        
    }
       
        
    
