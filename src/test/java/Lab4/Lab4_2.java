package Lab4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab4_2 {
	public static void main(String[] args) {
		String fileName = "numbers.txt";

		try {
			//Create numbers.txt with numbers 0 to 10 separated by commas
			FileWriter writer = new FileWriter(fileName);
			for (int i = 0; i <= 10; i++) {
				writer.write(i + (i < 10 ? "," : ""));
			}
			writer.close();
			System.out.println("numbers.txt created successfully!");

			//Read numbers from the file using Scanner
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter(",");

			System.out.println("Even numbers:");
			while (scanner.hasNext()) {
				int num = scanner.nextInt();
				if (num % 2 == 0) {
					System.out.print(num + " ");
				}
			}

			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
