package pack3;

	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.BeforeClass;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.AfterSuite;

	public class Lab14_Selenium {
		WebDriver driver;
		String projectpath=System.getProperty("user.dir")  ;
	  @Test(dataProvider = "dp")
	  public void f(String firstname, String lastname, String email_id, String phnnumber,String password,String confirmpassword) throws InterruptedException {
		  Thread.sleep(3000);
		  String title=driver.getTitle();
		  System.out.println("Title:"+title);
		  //ExtentReports extent=new ExtentReports();
		  //String reportpath=projectpath+"\\param";
		  if(title.equals("Your Store"))
			{
				System.out.println(	"title is matched");
			}
			else
			{
				System.out.println("title is not mathed");
			}
		 driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		 driver.findElement(By.linkText("Register")).click();
		 WebElement text=driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
		 if(text.getText().equals("Register Account")) {
			 System.out.println("Text is matched");
		 }
		 else {
			 System.out.println("text is mismatched");
		 }
		 //Enter all the details in the First name, Last Name, E-Mail, Telephone, Password,  Password Confirm from the excel sheet (UserDetails.xls)
		 driver.findElement(By.name("firstname")).sendKeys(firstname);
		 driver.findElement(By.name("lastname")).sendKeys(lastname);
		 driver.findElement(By.name("email")).sendKeys(email_id);
		 driver.findElement(By.name("telephone")).sendKeys(String.valueOf(phnnumber));
		 driver.findElement(By.name("password")).sendKeys(password);
		 driver.findElement(By.name("confirm")).sendKeys(confirmpassword);
		// Click on checkbox of newsLetter
		 driver.findElement(By.name("newsletter")).click();
		 //Select “I have read and agree to the Privacy Policy” check box
		 driver.findElement(By.name("agree")).click();
		 //click on continue
		 driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://tutorialsninja.com/demo/index.php");
	  }

	  @AfterMethod
	  public void afterMethod() {
	  }

	  @DataProvider
	  public Object[][] dp() throws IOException {
	  String[][] data=new String[2][6];
	  String projectpath=System.getProperty("user.dir");
	  File file=new File(projectpath+"\\Userdetails_L14.xlsx");
	  FileInputStream fs=new FileInputStream(file);
	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
	  XSSFSheet worksheet=workbook.getSheetAt(0);
	  int rowcount=worksheet.getPhysicalNumberOfRows();
	  System.out.println("rows:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=worksheet.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=worksheet.getRow(i).getCell(3).toString();
		  data[i][4]=worksheet.getRow(i).getCell(4).getStringCellValue();
		  data[i][5]=worksheet.getRow(i).getCell(5).getStringCellValue();
	  }
	  
	  return data;
	  }
		@BeforeClass
		public void beforeClass() {
			  System.out.println("Before class");
		}

		@AfterClass
		public void afterClass() {
			  System.out.println("After Class");
		}

		@BeforeTest
		public void beforeTest() {
			  System.out.println("Before Test");
		}

		@AfterTest
		public void afterTest() {
			  System.out.println("After Test");
		}

		@BeforeSuite
		public void beforeSuite() {
			  System.out.println("Before Suite");
		}

		@AfterSuite
		public void afterSuite() {
			  System.out.println("After Suite");
		}

	}