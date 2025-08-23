package pac1;
 
import org.testng.annotations.Test;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
 
public class LAB_14 {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String firstname, String lastname, String email, String phone, String password, String confpass) {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  LAB_14po obj_14 = new LAB_14po(driver);
	  obj_14.accountreg();
	  obj_14.registeruser(firstname, lastname, email, phone, password, confpass);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
  }
 
  @AfterMethod
  public void afterMethod() {
  }
 
 
  @DataProvider
  public Object[][] dp() throws IOException {
      String projectPath = System.getProperty("user.dir");
      File file = new File(projectPath + "\\Lab14_details.xlsx"); // corrected spelling
      if(!file.exists()) {
          throw new IOException("Excel file not found at: " + file.getAbsolutePath());
      }

      FileInputStream fis = new FileInputStream(file);
      XSSFWorkbook workbook = new XSSFWorkbook(fis);
      XSSFSheet sheet = workbook.getSheetAt(0);

      int rowCount = sheet.getPhysicalNumberOfRows();
      int colCount = 6; // as per your test method

      String[][] data = new String[rowCount][colCount];

      for(int i=0; i<rowCount; i++) {
          for(int j=0; j<colCount; j++) {
              if(sheet.getRow(i).getCell(j) != null) {
                  data[i][j] = sheet.getRow(i).getCell(j).toString();
              } else {
                  data[i][j] = "";
              }
          }
      }

      workbook.close();
      fis.close();

      return data;
  }
}