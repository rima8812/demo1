package ExtendReport;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import XeroApp_Assignment.XeroApp.TestBase1;

public class TestID06 extends TestBase1 {
	@Test(dataProvider = "loginUserDataDetails")
	public void TestID06A(String sUserName,String sPassword,String sXpath,String sTestCaseName) throws Exception {
		logger = reports.startTest(sTestCaseName);
		
		logger.log(LogStatus.INFO, "Sucessfully Launced Aplication");
		
		oBroUtil.LogintoWebsite(sUserName, sPassword);
		logger.log(LogStatus.INFO, "Sucessfully Enter User Details");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-1']")).click();
		driver.findElement(By.xpath("//span[(contains(text(),'Edit Profile'))]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Upload Image')]")).click();
		WebElement eleChoosebutton=driver.findElement(By.xpath("//input[@name='file']"));
		eleChoosebutton.sendKeys("C:\\Test\\Temp.jpg");
		logger.log(LogStatus.INFO,"Sucessfully uploaded Image");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='toolbar-1232-innerCt']//div[@class='x-btn-wrap']//a[@class='x-btn-button']//span[contains(text(),'Upload')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
		logger.log(LogStatus.INFO,"Sucessfully uploaded Image & is displayed");
		logger.log(LogStatus.INFO,"TestID06 is Pass");
		
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+sTestCaseName+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
}
		@DataProvider(name="loginUserDataDetails")
		public Object[][] getDataForLogin() throws Exception{
			return new Object[][] {{"rimapatil777@gmail.com","rimapatil12","//img[@class='your-logo']","TestID06"}};			
		}
}
