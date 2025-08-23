package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Lab3 {
    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");
        System.out.println("Before Class - Browser Opened");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test(dataProvider = "dp")
    public void f(Integer num, String str) throws InterruptedException {
        // Open Desktops -> Show All Desktops
        driver.findElement(By.xpath("a[normalize-space()='Desktops']")).click();
        driver.findElement(By.xpath("a[normalize-space()='Show All Desktops']")).click();

        // Sort dropdown
        WebElement sortDropdown = driver.findElement(By.id("input-sort"));
        Select select = new Select(sortDropdown);
        select.selectByVisibleText("Name (A - Z)");

        // Print first product name
        WebElement firstProduct = driver.findElement(By.xpath("//*[@id='content']//div[@class='product-thumb'][1]//h4/a"));
        System.out.println("Test Data: " + num + " - " + str + " | First product: " + firstProduct.getText());

        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        System.out.println("After Class - Browser Closed");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]{
                {1, "a"},
                {2, "b"}
        };
    }
}
