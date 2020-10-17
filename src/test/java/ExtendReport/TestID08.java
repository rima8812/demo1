package ExtendReport;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID08 extends TestBase1{
	@Test(dataProvider = "loginUserDataDetails")
	public void TestID08A(String sUserName,String sPassword,String sXpath,String sTestCaseName) throws Exception {
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		oBroUtil.LogintoWebsite(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Sucessfully Enter User Details");
		
	Thread.sleep(3000);
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//span[contains(text(),'Temp')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'My Xero')]")).click();
	Thread.sleep(3000);
	ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
	driver.switchTo().window(windowTabs.get(1));
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[contains(text(),'Add an organization')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@class='xui-textinput--input xui-textinput--input-medium']")).sendKeys("self");
	driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("sess");
	driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("United States");
	
	driver.findElement(By.xpath("//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small']")).click();
	driver.findElement(By.xpath(sXpath)).click();
	
	driver.switchTo().window(windowTabs.get(0));
	logger.log(LogStatus.INFO,"Sucessfully Created New Organisation");
	logger.log(LogStatus.INFO,"TestID08A is Pass");

	TakesScreenshot ts = (TakesScreenshot) driver; 
	File source = ts.getScreenshotAs(OutputType.FILE);
	String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
	File dest = new File(sPathOFScreenshot);
	FileUtils.copyFile(source, dest);
	logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
	}
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","//button[contains(text(),'Start trial')]","TestID08A"}};			
	}
	
	@Test(dataProvider = "UserDataDetails")
	public void TestID08B(String sUserName,String sPassword,String sXpath,String sTestCaseName) throws Exception {
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		oBroUtil.LogintoWebsite(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Sucessfully Enter User Details");
		
	Thread.sleep(3000);
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//span[contains(text(),'Temp')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'My Xero')]")).click();
	Thread.sleep(3000);
	ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
	driver.switchTo().window(windowTabs.get(1));
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//a[contains(text(),'Add an organization')]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@class='xui-textinput--input xui-textinput--input-medium']")).sendKeys("self");
	driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("sess");
	driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("United States");
	
	driver.findElement(By.xpath("//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small']")).click();
	driver.findElement(By.xpath(sXpath)).click();
	
	driver.switchTo().window(windowTabs.get(0));
	logger.log(LogStatus.INFO,"Sucessfully Created New Organisation");
	logger.log(LogStatus.INFO,"TestID08A is Pass");

	TakesScreenshot ts = (TakesScreenshot) driver; 
	File source = ts.getScreenshotAs(OutputType.FILE);
	String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
	File dest = new File(sPathOFScreenshot);
	FileUtils.copyFile(source, dest);
	logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
	}
	@DataProvider(name="UserDataDetails")
	public Object[][] getDataForLogin1() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","//button[contains(text(),'Buy now')]","TestID08B"}};			
	}

}
