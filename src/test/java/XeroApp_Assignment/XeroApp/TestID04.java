package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID04 {

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
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		
		Thread.sleep(4000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='userName']")).isDisplayed(), true);
			System.out.println("Username filed is displayed");
			System.out.println("TestID04 is Pass");
			driver.quit();

	}

}
