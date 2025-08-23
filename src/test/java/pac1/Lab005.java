package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Lab005 {


		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/index.php?");

			
			String title = driver.getTitle();
	        System.out.println("page title: " + title);
	        if (title.equals("Your Store"))
	        {
	            System.out.println("Title matches");
	        }
	        else
	        {
	            System.out.println("Title not matches");
	        }
	        
	        WebElement account = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a"));
	        account.click();
	        
	       
			WebElement register = driver.findElement(By.linkText("Register"));
			register.click();
	        WebElement regisHeader = driver.findElement(By.xpath("/html/body/div[2]/div/div/h1"));
	        if(regisHeader.isDisplayed())
	        {
	        	System.out.println("Register heading is displayed " + regisHeader.getText());
	        		
	        }
	        else 
	        {
	        		System.out.println("Register heading is not found");
	        }
	        
	        WebElement Submitbutton= driver.findElement(By.xpath("//input[@type='submit']"));
	        Submitbutton.click();
	        
	        
	        WebElement warningMsg = driver.findElement(By.xpath("/html/body/div[2]/div[1]"));
	   
	        if(warningMsg.getText().contains("Warning: You must agree to the Privacy Policy!"))
	        {
	        	System.out.println(" msg verified");
	        }
	        else
	        {
	        	System.out.println(" not verified");
	        }

		}
}
