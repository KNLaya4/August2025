package pac1;

import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Page {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "dp")
    public void loginTest(String username, String password) {
        System.out.println("Page Title: " + driver.getTitle());

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        
        Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Login might have failed!");
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
            {"Admin", "admin123"},   
            {"pooja", "admin123"}    
        };
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
