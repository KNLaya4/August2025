package pack3;

import java.time.LocalDate;
import java.time.Period;

public class lab15 {
    String firstName;
    String lastName;
    LocalDate dob;

    public lab15(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getFullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears();
    }

    public void displayDetails() {
        String fullName = getFullName(firstName, lastName);
        int age = calculateAge(dob);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Age: " + age + " years");
    }

    public static void main(String[] args) {
        String firstName = "K";
        String lastName = "Laya";
        LocalDate dob = LocalDate.of(2002, 6, 9);

        lab15 person = new lab15(firstName, lastName, dob);
        System.out.println("Person Details -");
        person.displayDetails();
    }
}