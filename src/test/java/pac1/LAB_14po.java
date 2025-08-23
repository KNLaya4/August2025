package pac1;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LAB_14po {
	WebDriver driver;
	public LAB_14po(WebDriver driver3) {
		this.driver = driver3;
	}
	
	By account = By.cssSelector("span.caret");
	By register = By.linkText("Register");
	By firstname_1 = By.name("firstname");
	By lastname_1 = By.name("lastname");
	By email_1 = By.name("email");
	By number_1 = By.name("telephone");
	By password_1 = By.name("password");
	By confpass_1 = By.name("confirm");
	By newlet = By.name("agree");
	By confirm = By.cssSelector("input.btn.btn-primary");
	
	public void accountreg() {
		driver.findElement(account).click();
		driver.findElement(register).click();
	}
	public void registeruser(String firstname, String lastname, String email, String phone, String password, String confpass ) {
		driver.findElement(firstname_1).sendKeys(firstname);
		driver.findElement(lastname_1).sendKeys(lastname);
		driver.findElement(email_1).sendKeys(email);
		driver.findElement(number_1).sendKeys(String.valueOf(phone));
		driver.findElement(password_1).sendKeys(password);
		driver.findElement(confpass_1).sendKeys(confpass);
		driver.findElement(newlet).click();
		driver.findElement(confirm).click();
	}
	
	
 
}
