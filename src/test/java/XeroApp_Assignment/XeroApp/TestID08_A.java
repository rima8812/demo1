package XeroApp_Assignment.XeroApp;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID08_A {

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
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'Temp')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'My Xero')]")).click();
		Thread.sleep(3000);
		ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(1));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add an organization')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@class='xui-textinput--input xui-textinput--input-medium']")).sendKeys("self");
		driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("sess");
		driver.findElement(By.xpath("//input[@class='xui-autocompleter--textinput xui-textinput--input xui-textinput--input-medium']")).sendKeys("United States");
		
		driver.findElement(By.xpath("//div[@class='xui-styledcheckboxradio--radio xui-styledcheckboxradio--radio-small']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Start trial')]")).click();
		
		driver.switchTo().window(windowTabs.get(0));
			System.out.println("Sucessfully Created New Organisation");
			System.out.println("TestID08A is Pass");
			driver.quit();


	}

}
