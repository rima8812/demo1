package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase1 {
	public static XeroUtility oBroUtil = new XeroUtility();
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath = System.getProperty("user.dir")+"/ExtentReport/TestID01.html";
	
	@BeforeSuite
	public void launchingTheBrowser() throws Exception{
		reports = new ExtentReports(sPath);
		driver = oBroUtil.LaunchBrowser("Chrome");
	}
	@AfterSuite
	public void closingTest() {
		oBroUtil.ExitBrowser();
		reports.flush();
	}
}
