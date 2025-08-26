package Question;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Q3 {
	WebDriver driver;
  @Test
  public void f() {
	  driver =new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button")).click();
	  
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  List<WebElement> laptop=driver.findElements(By.xpath("//div[@role='listitem' and @data-component-type='s-search-result']"));
	  int i=0;
	  for(WebElement lap:laptop)
	  {
		  i++;
		  System.out.println(lap.getText());
		  System.out.println();
		  if(i==5)
		  {
			  break;
		  }
	  }
	  
  }
}