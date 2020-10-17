package ExtendReport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;

public class TestID03 extends TestBase1{
	@Test(dataProvider = "loginUserDataDetails")
	public void TestID03_A(String sUserName,String sPassword,String sTestCaseName) throws Exception {
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		oBroUtil.LogintoWebsite(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Sucessfully Enter User Details");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']")).click();
		
		if(driver.findElement(By.xpath("//span[contains(text(),'s get set up')]")).isDisplayed()==true){
			logger.log(LogStatus.INFO, "Dashboard Page is displayed");
		}
		driver.findElement(By.xpath("//button[@name='navigation-menu/accounting']")).click();
		if(driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "accounting Page is displayed");
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Reports')]")).click();
		if(driver.findElement(By.xpath("//h1[contains(text(),'Reports')]")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "Reports Page is displayed");
		}
		
		driver.findElement(By.xpath("//button[@name='navigation-menu/contacts']")).click();
		if(driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "contacts Page is displayed");
		}
		
		driver.findElement(By.xpath("//*[contains(@d,'M7 5h5v2H7')]")).click();
		if(driver.findElement(By.xpath("//ol[@class='xrh-verticalmenu']/li")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "QuickLaunch Menu is displayed");
		}
		
		driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']")).click();
		driver.findElement(By.xpath("//div[@class='xrh-focusable--child xrh-iconwrapper']")).click();
		if(driver.findElement(By.xpath("//div[@class='panelBody']")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "Notification Menu is displayed");
		}
		
		driver.findElement(By.xpath("//li[4]//button[1]//div[1]//*[local-name()='svg']//*[name()='path' and contains(@d,'M7.5 15a7.')]")).click();
		if(driver.findElement(By.xpath("//h3[contains(text(),'Help')]")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "Help Menu is displayed");
		}
		
		driver.findElement(By.xpath("//li[2]//button[1]//div[1]//*[local-name()='svg']")).click();
		if(driver.findElement(By.xpath("//input[@id='queryInput']")).isDisplayed()==true)
		{
			logger.log(LogStatus.INFO, "Search Menu is displayed");
		}
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		reports.endTest(logger);
		
			driver.quit();

	}
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","TestID03"}};
	}
}
