package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.opencart.com/");
        String title = driver.getTitle();
        
        if (title.equals("OpenCart - Open Source Shopping Cart Solution")) { 
            System.out.println("Title is matched");
        } else {
            System.out.println("Title is not matched");
        }
        
        driver.navigate().to("https://yahoo.com/");
        System.out.println("URL is:"+driver.getCurrentUrl());
        
       
        driver.navigate().back();
        System.out.println("URL is:"+ driver.getCurrentUrl());
        
        System.out.println("URL:"+driver.getCurrentUrl());
        driver.navigate().forward();
        driver.navigate().refresh();
        
        System.out.println("url is:"+driver.getCurrentUrl());
        
        System.out.println("page source is:"+driver.getPageSource());
        driver.quit();      
    }
}


