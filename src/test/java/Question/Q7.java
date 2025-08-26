package Question;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class Q7 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void extractTableData() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
        System.out.println("Names from first table:");
        for (WebElement name : names) {
            System.out.println(name.getText());
        }
        String email = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Jason']/following-sibling::td[1]")).getText();
        System.out.println("Email of Jason: " + email);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}