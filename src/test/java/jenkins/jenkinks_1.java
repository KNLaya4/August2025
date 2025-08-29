package jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jenkinks_1 {
  @Test
  public void f() {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

      // Wait until username field is visible
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");

      driver.findElement(By.name("password")).sendKeys("admin123");
      driver.findElement(By.xpath("//button[@type='submit']")).click();

      // (Optional) verify login by checking for dashboard element
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));

      driver.quit();  // Close browser after test
  }
}
