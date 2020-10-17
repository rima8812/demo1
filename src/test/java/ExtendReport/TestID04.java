package ExtendReport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;

public class TestID04 extends TestBase1{
	@Test(dataProvider = "loginUserDataDetails")
	public void TestID04A(String sUserName,String sPassword,String sXpath,String sTestCaseName) throws Exception {
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		oBroUtil.LogintoWebsite(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Sucessfully Enter User Details");

		driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-1']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		logger.log(LogStatus.INFO, "Sucessfully Clicked on LogOut");
		
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
		logger.log(LogStatus.INFO,"Username filed is displayed");
		logger.log(LogStatus.INFO,"TestID04 is Pass");
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
}
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","//input[@name='userName']","TestID04"}};			
	}
	
}
