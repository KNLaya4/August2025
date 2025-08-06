package pack3;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class lab11 {
    public static void main(String[] args) {
        LocalDate givenDate = LocalDate.of(2022, 2, 27);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(givenDate, currentDate);
        long totalDays = ChronoUnit.DAYS.between(givenDate, currentDate);

        System.out.println("Given Date: " + givenDate);
        System.out.println("Current Date: " + currentDate);
        System.out.println("Duration:");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
        System.out.println("Total Days: " + totalDays);
    }
}