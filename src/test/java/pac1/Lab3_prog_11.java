package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Lab3_prog_11 {
	WebDriver driver;
	
	public Lab3_prog_11(WebDriver driver2) {
		this.driver = driver2;
		
	}
	By desktop = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By sortDrop = By.id("input-sort");
	By addToCart = By.cssSelector(".button-group > button:nth-child(1)");
	By bodyTag = By.tagName("body");
	
	public void MacDesk() {
		driver.findElement(desktop).click();
		driver.findElement(mac).click();
	}
	
	public void sortName() {
		WebElement dropdown = driver.findElement(sortDrop);
		new Select(dropdown).selectByVisibleText("Name (A - Z)");
	}
	
	public void product() {
		driver.findElement(addToCart).click();
	}
}