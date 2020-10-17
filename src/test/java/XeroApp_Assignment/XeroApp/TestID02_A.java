package XeroApp_Assignment.XeroApp;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID02_A {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("rrrr");
		
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("pppp");
		
		driver.findElement(By.xpath("//input[@name='EmailAddress']")).sendKeys("rimapatil777@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='PhoneNumber']")).sendKeys("990990090");
		
		Select sLocation=new Select(driver.findElement(By.xpath("//select[@name='LocationCode']")));
		sLocation.selectByVisibleText("India");
		
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
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='btn btn-primary']")).isDisplayed(), true);
			System.out.println("Inbox Page is displayed");
			System.out.println("TestID02_A is Pass");
			driver.quit();

	}

}
