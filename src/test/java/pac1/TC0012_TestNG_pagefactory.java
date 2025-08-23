package pac1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC0012_TestNG_pagefactory {
    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Initialize Extent Report
        String reportpath = projectpath + "\\reports\\Wipro_javaseleniumreport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        extent.flush();
    }

    @Test(dataProvider = "dp")
    public void loginTest(String username, String password) throws IOException, InterruptedException {
        Thread.sleep(3000);  // wait for page load

        String title = driver.getTitle();
        System.out.println("The Title is: " + title);

        test = extent.createTest("Verify Login with Username: " + username);

        if (title.equals("OrangeHRM")) {
            test.pass("Title matched: " + title);
        } else {
            test.fail("Title not matched, found: " + title);

            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String dest = projectpath + "\\screenshots\\screenshot_" + System.currentTimeMillis() + ".png";
            FileUtils.copyFile(scr, new File(dest));
            test.addScreenCaptureFromPath(dest);
        }

        // Use Page Object
        login_pageobjects obj = new login_pageobjects(driver);
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        FileInputStream fs = new FileInputStream(projectpath + "\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowcount - 1][2];

        for (int i = 1; i < rowcount; i++) {  // skip header
            data[i - 1][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
            data[i - 1][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
        }

        workbook.close();
        return data;
    }
}
