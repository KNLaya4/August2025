package Question;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Set;

public class Q8 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void handleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                System.out.println("Child Window Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Window Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}