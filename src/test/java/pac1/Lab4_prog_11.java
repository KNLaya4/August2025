package pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Lab4_prog_11 {
	WebDriver driver;
	
	public Lab4_prog_11(WebDriver driver2) {
		this.driver = driver2;
		
	}
	By desktop = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By sortDrop = By.id("input-sort");
	By addToCart = By.cssSelector(".button-group > button:nth-child(1)");
	By searchbox = By.name("search");
	By searchbtn = By.xpath("//*[@id='search']/span/button");
	By searchipt = By.id("input-search");
	By descript = By.xpath("//*[@id='description']");
	By searchdescrp = By.id("button-search");
	
	public void MacDesk_1() {
		driver.findElement(desktop).click();
		driver.findElement(mac).click();
	}
	
	public void sortName_1() {
		WebElement dropdown = driver.findElement(sortDrop);
		new Select(dropdown).selectByVisibleText("Name (A - Z)");
	}
	
	public void product_1() {
		driver.findElement(addToCart).click();
	}
	
	public void search_1() {
		driver.findElement(searchbox).click();
		driver.findElement(searchbox).sendKeys("Monitors");
		driver.findElement(searchbtn).click();
	}
	
	public void descript_1() {
		driver.findElement(searchipt).clear();
		driver.findElement(descript).click();
		driver.findElement(searchdescrp).click();
	}
}