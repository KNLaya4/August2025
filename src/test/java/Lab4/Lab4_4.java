package Lab4;

import java.util.ArrayList;
import java.util.Collections;
// Lab4_3  to store product names in an ArrayList, sort strings 
public class Lab4_4 {

	public static void main(String[] args) {

		// Create ArrayList to store product names
		ArrayList<String> products = new ArrayList<>();

		//Add product names
		products.add("Laptop");
		products.add("Phone");
		products.add("Tablet");
		products.add("Smartwatch");
		products.add("Camera");

		//Sort the ArrayList alphabetically
		Collections.sort(products);

		System.out.println("Sorted Product Names:");
		for (String product : products) {
			System.out.println(product);
		}
	}
}