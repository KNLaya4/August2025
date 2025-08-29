package Question;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {
	WebDriver driver;
 @Test
 public void f() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.get("https://www.amazon.in/");
	  Thread.sleep(3000);
	  WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	  search.sendKeys("laptop",Keys.ENTER);
	  Thread.sleep(3000);
	  List<WebElement> products = driver.findElements(By.cssSelector("h2.a-size-medium"));
	  System.out.println("First 5 products name");
	  for(int i=0;i<5;i++) {
		
		  System.out.println((i+1)+ ": " + products.get(i).getText());
 }
 }
 @BeforeClass
 public void setup() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  
		  
	  
 }
 @AfterClass
 public void close() {
	  driver.quit();
 }
}