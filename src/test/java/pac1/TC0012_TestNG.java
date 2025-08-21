package pac1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC0012_TestNG {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void f(String username, String password) throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is: " + title);
        Thread.sleep(3000);

        // Use Page Object
        login_pageobjects obj = new login_pageobjects(driver);
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { "Admin", "admin123" },
            new Object[] { "Anu", "anu123" }
        };
    }
}
