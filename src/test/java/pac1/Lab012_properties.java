package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab012_properties {
	public static void main(String[] args) {

        // Load config.property
        Lab12_toloadProperties p = new Lab12_toloadProperties(
                "C:\\Users\\DELL\\eclipse-workspace\\wipro2025\\Lab12login.properties");
        // Use WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
     // Navigate to URL
        driver.get(p.getProperty("url"));

        // Perform login
        driver.findElement(By.name(p.getProperty("username"))).sendKeys("testuser@test.com");
        driver.findElement(By.xpath(p.getProperty("password"))).sendKeys("test123");
        driver.findElement(By.xpath(p.getProperty("login_button"))).click();
        driver.quit();
	}
}
