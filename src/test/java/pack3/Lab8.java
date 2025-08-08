package pack3;

public class Lab8 {
	
	    public enum Gender {
	        M, F
	    }

	    String firstName;
	    String lastName;
	    Gender gender;

	    Lab8(String firstName, String lastName, Gender gender) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public Gender getGender() {
	        return gender;
	    }

	    public void setGender(Gender gender) {
	        this.gender = gender;
	    }

	    public void display() {
	        System.out.println("Person details:");
	        System.out.println("------------------------");
	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Gender: " + (gender == Gender.F ? "M" : "F"));
	    }

	    public void phNumber(long phNumber) {
	        System.out.println("Phone Number: " + phNumber);
	    }
	}