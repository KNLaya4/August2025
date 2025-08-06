package pack1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DurationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Enter a date (dd-MM-yyyy): ");
        String input = scanner.nextLine();
        try {
            LocalDate inputDate = LocalDate.parse(input, formatter);
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(inputDate, currentDate);
            System.out.println("Years : " + Math.abs(period.getYears()));
            System.out.println("Months: " + Math.abs(period.getMonths()));
            System.out.println("Days  : " + Math.abs(period.getDays()));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
        }
        scanner.close();
    }
}

