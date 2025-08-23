package com.orangehrm.stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	WebDriver driver;
	
	
@Given("Launch the Browser")
public void launch_the_browser() {
    
    WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	    
    
}

@Given("Navigate to the URL")
public void navigate_to_the_url() {
    
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   
}

@When("Enter the username and password")
public void enter_the_username_and_password() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement usernameField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.name("username"))
    );
    usernameField.sendKeys("Admin");

    WebElement passwordField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.name("password"))
    );
    passwordField.sendKeys("admin123");
}


@When("Click on Login Button")
public void click_on_login_button() {
    
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	
}

@Then("Login should be successful")
public void login_should_be_successful() {
    
    String title=driver.getTitle();
	System.out.println("The Title is:"+title);
	if(title.equalsIgnoreCase("OrangeHRM"))
	{
		System.out.println("Login Suucessfull");
	}
	else
	{
		System.out.println("Login unSuucessfull");
	}
}
}
