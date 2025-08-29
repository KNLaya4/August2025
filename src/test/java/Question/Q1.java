package Question;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	WebDriver driver;
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com");
	  String s=driver.getTitle();
	  System.out.println(s);
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  }