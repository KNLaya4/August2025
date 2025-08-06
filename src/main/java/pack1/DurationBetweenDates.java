package pack1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DurationBetweenDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter the first date (dd-MM-yyyy): ");
        String firstDateInput = scanner.nextLine();

        System.out.print("Enter the second date (dd-MM-yyyy): ");
        String secondDateInput = scanner.nextLine();

        try {
            LocalDate firstDate = LocalDate.parse(firstDateInput, formatter);
            LocalDate secondDate = LocalDate.parse(secondDateInput, formatter);

            Period period = Period.between(firstDate, secondDate);

            System.out.println("Duration between " + firstDate + " and " + secondDate + ":");
            System.out.println("Years : " + Math.abs(period.getYears()));
            System.out.println("Months: " + Math.abs(period.getMonths()));
            System.out.println("Days  : " + Math.abs(period.getDays()));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
        }

        scanner.close();
    }
}
