package XeroApp_Assignment.XeroApp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID06 {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Username']")).click();
		driver.findElement(By.xpath("//input[@name='Username']")).clear();
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("rimapatil777@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='Password']")).click();
		driver.findElement(By.xpath("//input[@name='Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("rimapatil12");
		
		driver.findElement(By.xpath("//button[@value='login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-1']")).click();
		driver.findElement(By.xpath("//span[(contains(text(),'Edit Profile'))]")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Upload Image')]")).click();
		WebElement eleChoosebutton=driver.findElement(By.xpath("//td[@id='filefield-1174-browseButtonWrap']"));
		eleChoosebutton.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Test\\FileUpload.exe");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Upload')][2]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//img[@class='your-logo']")).isDisplayed(), true);
			System.out.println("Sucessfully uploaded Image & is displayed");
			System.out.println("TestID06 is Pass");
			driver.quit();


	}

}
