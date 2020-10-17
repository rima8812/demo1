package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID02_B {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys("rrrrr.com");
		
		driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='TermsAccepted']")).isDisplayed(), true);
			System.out.println("term and Policy checkbox is highlighted.");
			System.out.println("TestID02_B is Pass");
			driver.quit();

	}

}
