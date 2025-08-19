package pac1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0013 {

    @Test(priority=3)
    public void test1() {
        System.out.println("This is test1");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        Assert.assertEquals(driver.getTitle(),
            "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");

        driver.quit();
    }

    @Test(priority=1)
    public void test2() {
        System.out.println("This is test2");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://yahoo.com/");
        Assert.assertTrue(driver.getTitle().contains("Yahoo"));
        driver.quit();
    }

    @Test(priority=2)
    public void test3() {
        System.out.println("This is test3");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");
        Assert.assertTrue(driver.getTitle().contains("Myntra"));
        
    }
}
 