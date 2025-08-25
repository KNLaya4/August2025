package pac1;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.opencsv.exceptions.CsvException;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
 
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class Lab_16 {
WebDriver driver;
String projectpath=System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
  String title=driver.getTitle();
System.out.println("The Title is:"+title);
Thread.sleep(3000);
login_pagefactory obj=PageFactory.initElements(driver, login_pagefactory.class);
obj.enterusername(username);
obj.enterpassword(password);
obj.clickonlogin();
}
  @BeforeMethod
  public void beforeMethod() {
System.out.println("Before method");
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
  @AfterMethod
  public void afterMethod() {
System.out.println("After method");
driver.quit();
  }
 
 
  @DataProvider
  public Object[][] dp() throws IOException, CsvException, ParserConfigurationException, SAXException {
	  String[][] data1=new String[2][2];
File file = new File(projectpath+"\\Lab16_data.xml");
 
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 
Document doc = dBuilder.parse(file);
doc.getDocumentElement().normalize();
 
System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
 
NodeList nList = doc.getElementsByTagName("user");
 
for (int i = 0; i < nList.getLength(); i++) {
     Node node = nList.item(i);
 
     if (node.getNodeType() == Node.ELEMENT_NODE) {
         Element element = (Element) node;
 
        data1[i][0] = element.getElementsByTagName("username").item(0).getTextContent();
        data1[i][1] = element.getElementsByTagName("password").item(0).getTextContent();
       
         System.out.println("username: " +  data1[i][0]);
         System.out.println("password: " +  data1[i][1]);
         
     }
}
 
return data1;
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
  System.out.println("After Suite");
  }
}

