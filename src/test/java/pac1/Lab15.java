package pac1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab15 {
    WebDriver driver;
    String url;
    String expectedTitle;

    @BeforeMethod
    public void setup() throws IOException {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Read CSV file (first line)
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\DELL\\eclipse-workspace\\wipro2025\\Lab15.csv"));
        String line = br.readLine(); // read first row
        if (line != null) {
            String[] values = line.split(",");
            url = values[0];
            expectedTitle = values[1];
        }
        br.close();
    }

    @Test
    public void readCsvAndOpenUrl() {
        // Open URL
        driver.get(url);

        // Verify title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title matched: " + actualTitle);
        } else {
            System.out.println("Title NOT matched. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
