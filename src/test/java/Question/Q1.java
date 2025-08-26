package Question;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1{
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogle() {
        driver.get("https://www.google.com");
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}