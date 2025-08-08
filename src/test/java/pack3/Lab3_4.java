package pack3;

import java.util.Arrays;

public class Lab3_4 {
    public static void main(String[] args) {
        String[] products = {"Gram flour", "Colgate Max Fresh", "Brush", "Shampoo", "Oil"};
        Arrays.sort(products);

        System.out.println("Sorted Product Names:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}