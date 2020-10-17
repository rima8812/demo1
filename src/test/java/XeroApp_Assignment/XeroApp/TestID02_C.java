package XeroApp_Assignment.XeroApp;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID02_C {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Free trial')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'terms')]")).click();
		Thread.sleep(3000);
		ArrayList <String> windowTabs=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windowTabs.get(1));
		System.out.println("Sucessfully opened A new Xero terms of use web page.");
		driver.close();
		driver.switchTo().window(windowTabs.get(0));
		
		driver.findElement(By.xpath("//a[contains(text(),'privacy')]")).click();
		Thread.sleep(3000);
		ArrayList <String> windowTabs1=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(windowTabs1.get(1));
		System.out.println("Sucesssfully opened A new Privacy policy web page.");
		driver.close();
		driver.quit();

	}

}
