package Lab4;

import java.io.*;

public class Lab4_1 {
    public static void main(String[] args) {
        String fileName = "sample2.txt";

        try {
            File file = new File(fileName);

            // Create the file with some default text if it doesn't exist
            if (!file.exists()) {
                System.out.println("sample.txt not found, creating with default content...");
                Writer writer = new FileWriter(file);
                writer.write("Hello World");
                writer.close();
                System.out.println("sample.txt created with default content: Hello World");
            }

            //  Read content from file
            Reader reader = new FileReader(file);
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
            reader.close();

            // Reverse the content
            String reversedContent = content.reverse().toString();

            // Write reversed content back to the file
            Writer writer = new FileWriter(file);
            writer.write(reversedContent);
            writer.close();

            System.out.println("File content reversed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}