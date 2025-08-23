package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class Lab5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

       
        String expectedTitle = "nopCommerce demo store";
        if (!driver.getTitle().equals(expectedTitle)) {
            System.out.println("Title mismatch! Actual: " + driver.getTitle());
        }

    
        driver.findElement(By.className("ico-register")).click();

        
        WebElement heading = driver.findElement(By.tagName("h1"));
        if (!heading.getText().equals("Register")) {
            System.out.println("Heading mismatch!");
        }

        
        driver.findElement(By.id("FirstName")).sendKeys("Laya");
        driver.findElement(By.id("LastName")).sendKeys("Test");

        driver.findElement(By.id("Email")).sendKeys("laya" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(By.id("Password")).sendKeys("Test1234");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Test1234");

        driver.findElement(By.id("register-button")).click();

        WebElement successMsg = driver.findElement(By.className("result"));
        if (successMsg.getText().contains("Your registration completed")) {
            System.out.println("✅ Account created successfully!");
        } else {
            System.out.println("❌ Account creation failed!");
        }

        driver.quit();
    }
}
