package ExtendReport;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;
public class TestID01 extends TestBase1{

	@Test(dataProvider = "loginUserDataDetails")
	public void TestID01A(String sUserName,String sPassword,String sXpath,String sTestCaseName) throws Exception{
			logger = reports.startTest(sTestCaseName);
			
			logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
			
			oBroUtil.LogintoWebsite(sUserName, sPassword);
			logger.log(LogStatus.INFO, "Sucessfully Enter User Details");
			
			oBroUtil.ExplicitWaitFunc(driver.findElement(By.xpath(sXpath.trim())));
			if(sTestCaseName=="TestID01A") {
				Assert.assertEquals(driver.findElement(By.xpath(sXpath.trim())).isDisplayed(), true);
				driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-1']")).click();
			
				driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
				logger.log(LogStatus.INFO, "Sucessfully verifed Home PAge is displayed");
			}else
				Assert.assertEquals(driver.findElement(By.xpath(sXpath)).getText(), "Your email or password is incorrect");
				logger.log(LogStatus.INFO, "Sucessfully Verified Error Message");
			TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
			File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
			String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
			File dest = new File(sPathOFScreenshot);
			FileUtils.copyFile(source, dest);
			logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
			reports.endTest(logger);
	}
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","//a[@name='navigation-menu/dashboard']","TestID01A"},
			{"rimapatil777@gmail.com","rimapatil","//li[contains(text(),'Your email or password is incorrect')]","TestID01B"},
			{"rima@gmail.com","rimapatil","//li[contains(text(),'Your email or password is incorrect')]","TestID01C"}};
				
	}
	@Test(dataProvider="ForgotPasswordDetails",priority=2)
	public void ForgotPassowrd(String sUserName,String sXpath,String sTestCaseName) throws Exception{
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		logger = reports.startTest(sTestCaseName);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
	
		driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on  Forgot your password link");
		

		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(sUserName);
	
		driver.findElement(By.xpath("//span[contains(text(),'Send link')]")).click();
		oBroUtil.ExplicitWaitFunc(driver.findElement(By.xpath(sXpath.trim())));
		Assert.assertEquals(driver.findElement(By.xpath(sXpath.trim())).isDisplayed(), true);
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		reports.endTest(logger);
	}
	
	@DataProvider(name="ForgotPasswordDetails")
	public Object[][] getDataForForgotPasssowrd() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","//h2[contains(text(),'Please check your email')]","TestID01D"}};
				
	}
}
