package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Program8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void validLoginTest() {
        // Wait for username field
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("Admin");

        // Wait for password field
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("admin123");

        // Click login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();

        // Verify Dashboard appears
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        Assert.assertEquals(dashboard.getText(), "Dashboard");
    }

    @Test
    public void invalidLoginTest() {
        // Wait for username field
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        username.sendKeys("WrongUser");

        // Wait for password field
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        password.sendKeys("WrongPass");

        // Click login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        loginBtn.click();

        // Verify error message
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Invalid credentials')]")));
        Assert.assertEquals(error.getText(), "Invalid credentials");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
