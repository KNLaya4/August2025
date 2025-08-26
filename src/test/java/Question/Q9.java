package Question;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Q9 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void takeScreenshot() throws IOException {
        driver.get("https://www.wikipedia.org/");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(System.getProperty("user.dir") + "/homepage.png");
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}