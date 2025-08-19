package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab006 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?");
        System.out.println("Title :" + driver.getTitle());
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("laya99@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("laya999");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void addMonitorToWishlist() throws InterruptedException {
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.linkText("Monitors (2)")).click();
        WebElement sort = driver.findElement(By.id("input-limit"));
        new Select(sort).selectByIndex(1);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")).click();
        Thread.sleep(2000);
        System.out.println("Monitor added to wishlist.");
    }

    @AfterClass
    public void tearDown() {
       
        }
    }

