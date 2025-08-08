package pack3;

public class Person2_1{
    private String firstName;
    private String lastName;
    private char gender;
    private long phoneNumber;

    
    public Person2_1(String firstName, String lastName, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    
    public void phNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("Phone number set to: " + phoneNumber);
    }

   
    public void display() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Gender: " + gender);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
