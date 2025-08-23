package pac1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.time.Duration;
public class Lab3Test_11 {
  private WebDriver driver;
  private Map<String, Object> vars;
  private
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
  public void lab3() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://tutorialsninja.com/demo/index.php?");
    driver.manage().window().setSize(new Dimension(1552, 832));
    Lab3_prog_11 obj = new Lab3_prog_11(driver);
    obj.MacDesk();
    obj.sortName();
    obj.product();    
    
  }
}