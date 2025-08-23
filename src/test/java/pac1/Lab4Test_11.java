package pac1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.time.Duration;
public class Lab4Test_11 {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @BeforeMethod
public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @AfterMethod
public void tearDown() {
    driver.quit();
  }
  @Test
  public void lab4() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://tutorialsninja.com/demo/index.php?");
    driver.manage().window().setSize(new Dimension(1552, 832));
    Assert.assertEquals(driver.getTitle(), "Your Store");
    System.out.println("The Title Your Store is verified");
    
    Lab4_prog_11 obj_1 = new Lab4_prog_11(driver);
    
    obj_1.MacDesk_1();
    Assert.assertEquals(driver.getTitle(), "Mac");
    System.out.println("Title 'Mac' is verified");
    
    obj_1.sortName_1();
   
    obj_1.product_1();
    obj_1.search_1();
    obj_1.descript_1();
  }
}