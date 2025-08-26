package Question;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Q4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void selectOption() {
        WebElement dropdown = driver.findElement(By.name("my-select"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Two");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Two", "Dropdown selection failed!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}