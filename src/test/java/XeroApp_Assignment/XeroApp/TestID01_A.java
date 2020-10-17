package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID01_A {
	static int count=0;
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
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
		Assert.assertEquals(driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']")).isDisplayed(), true);
			System.out.println("User's Home Page is displayed");
			System.out.println("TestID01_A is Pass");
			driver.quit();
	}
}
