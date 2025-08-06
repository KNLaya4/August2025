package pack3;

import java.time.LocalDate;

public class lab13 {
    public void calculateWarrantyExpiry(LocalDate purchaseDate, int warrantyYears, int warrantyMonths) {
        LocalDate expiryDate = purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Warranty Period: " + warrantyYears + " years and " + warrantyMonths + " months");
        System.out.println("Warranty Expiry Date: " + expiryDate);
    }

    public static void main(String[] args) {
        lab13 obj = new lab13();

        LocalDate purchaseDate = LocalDate.of(2020, 6, 10);
        int warrantyYears = 2;
        int warrantyMonths = 6;

        obj.calculateWarrantyExpiry(purchaseDate, warrantyYears, warrantyMonths);
    }
}