package ExtendReport;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;

public class TestID02 extends TestBase1{
	@Test(dataProvider = "loginUserDataDetails")
	public void TestID02A(String FirstName,String LastName,String EmailAddress,String PhoneNumber,String Location,String sXpath,String sTestCaseName) throws Exception{
		logger = reports.startTest(sTestCaseName);
		
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on Free trial button");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FirstName);
		logger.log(LogStatus.INFO, "Sucessfully Entered FirstName");
		
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LastName);
		logger.log(LogStatus.INFO, "Sucessfully Entered LastName");
		
		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys(EmailAddress);
		logger.log(LogStatus.INFO, "Sucessfully Entered EmailAddress");
		
		driver.findElement(By.xpath("//input[@name='PhoneNumber']")).sendKeys(PhoneNumber);
		logger.log(LogStatus.INFO, "Sucessfully Entered PhoneNumber");
		
		Select sLocation=new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
		sLocation.selectByVisibleText(Location);
		logger.log(LogStatus.INFO, "Sucessfully Entered Location");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");
		
		Thread.sleep(3000);
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[contains(@name,'TermsAccepted')]")).click();
		driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		Thread.sleep(3000);
		if(driver.findElement(By.xpath(sXpath)).isDisplayed()==false); 
			{
				logger.log(LogStatus.FAIL, logger.addScreenCapture(sPathOFScreenshot));
			}
				logger.log(LogStatus.INFO, "Sucessfully Pass TestCase");	
				reports.endTest(logger);
	}
	
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		return new Object[][] {{"rrr","ppp","rimapatil777@gmail.com","900909090","India","//a[@class='btn btn-primary']","TestID02A"},};
				
	}
	
	@Test(dataProvider = "EmailDataDetails")
	public void TestID02B(String sEmail,String sXpath,String sTestCaseName ) throws Exception {
		logger = reports.startTest(sTestCaseName);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys("rrrrr.com");
		logger.log(LogStatus.INFO, "Sucessfully Enetered EmailAddress");	
		
		driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on Submit button");	
		
		Thread.sleep(3000);
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		if(driver.findElement(By.xpath("//input[@name='TermsAccepted']")).isDisplayed()!=true) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(sPathOFScreenshot));
		}
			logger.log(LogStatus.INFO, "term and Policy checkbox is highlighted.");
			logger.log(LogStatus.INFO, "TestID02_B is Pass");
	}
	@DataProvider(name="EmailDataDetails")
	public Object[][] getDataForLogin1() throws Exception{
		return new Object[][] {{"rrrrr.com","//input[@name='TermsAccepted']","TestID02B"}};
				
	}
	@Test
	public void TestID02C() throws Exception{
		logger = reports.startTest("TestID02C");
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on Free trial.");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'terms')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on term.");
		Thread.sleep(3000);
		ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
		Thread.sleep(3000);
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_TestID02C.png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		
		driver.switchTo().window(windowTabs.get(1));
		logger.log(LogStatus.INFO,"Sucessfully opened A new Xero terms of use web page.");
		driver.close();
		driver.switchTo().window(windowTabs.get(0));
		
		driver.findElement(By.xpath("//a[contains(text(),'privacy')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on privacy.");
		Thread.sleep(3000);
		ArrayList <String> windowTabs1=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windowTabs1.get(1));
		logger.log(LogStatus.INFO,"Sucesssfully opened A new Privacy policy web page.");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		driver.close();
	}
	@Test
	public void TestID02D() throws Exception {
			logger = reports.startTest("TestID02D");
			driver.get("https://www.xero.com/us/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
			logger.log(LogStatus.INFO, "Sucessfully Clicked on Free trial.");
			Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(),'offer details')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on offer details.");
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_TestID02D.png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		
		Thread.sleep(3000);
		ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(1));
		logger.log(LogStatus.INFO,"Sucessfully opened A new offer details web page.");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		driver.close();
		driver.switchTo().window(windowTabs.get(0));
	}
	
	@Test
	public void TestID02E() throws Exception {
			logger = reports.startTest("TestID02E");
			driver.get("https://www.xero.com/us/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
			logger.log(LogStatus.INFO, "Sucessfully Clicked on Free trial.");
			Thread.sleep(3000);
			
		driver.findElement(By.xpath("//a[contains(text(),'accountant or bookkeeper')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on Free trial.");
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_TestID02E.png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//h2[contains(text(),'Xero partner program signup form')]")).isDisplayed()==true) {
			logger.log(LogStatus.INFO,"Sucessfully opened A new offer details web page.");
			logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		}else
			logger.log(LogStatus.INFO,"Fail testcase");
			logger.log(LogStatus.FAIL, logger.addScreenCapture(sPathOFScreenshot));

	}
}
