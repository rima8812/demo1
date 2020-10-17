package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestID03 {

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
		driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']")).click();
		
		if(driver.findElement(By.xpath("//span[contains(text(),'s get set up')]")).isDisplayed()==true){
			System.out.println("Dashboard Page is displayed");
		}
		driver.findElement(By.xpath("//button[@name='navigation-menu/accounting']")).click();
		if(driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']")).isDisplayed()==true)
		{
			System.out.println("accounting Page is displayed");
		}
		
		driver.findElement(By.xpath("//a[contains(text(),'Reports')]")).click();
		if(driver.findElement(By.xpath("//h1[contains(text(),'Reports')]")).isDisplayed()==true)
		{
			System.out.println("Reports Page is displayed");
		}
		
		driver.findElement(By.xpath("//button[@name='navigation-menu/contacts']")).click();
		if(driver.findElement(By.xpath("//div[@class='xrh-dropdown-layout xrh-nav--dropdown xrh-dropdown-is-open xrh-dropdown-is-opening xrh-dropdown-positionleft']")).isDisplayed()==true)
		{
			System.out.println("contacts Page is displayed");
		}
		
		driver.findElement(By.xpath("//*[contains(@d,'M7 5h5v2H7')]")).click();
		if(driver.findElement(By.xpath("//ol[@class='xrh-verticalmenu']/li")).isDisplayed()==true)
		{
			System.out.println("QuickLaunch Menu is displayed");
		}
		
		driver.findElement(By.xpath("//a[@name='navigation-menu/dashboard']")).click();
		driver.findElement(By.xpath("//div[@class='xrh-focusable--child xrh-iconwrapper']")).click();
		if(driver.findElement(By.xpath("//div[@class='panelBody']")).isDisplayed()==true)
		{
			System.out.println("Notification Menu is displayed");
		}
		
		driver.findElement(By.xpath("//li[4]//button[1]//div[1]//*[local-name()='svg']//*[name()='path' and contains(@d,'M7.5 15a7.')]")).click();
		if(driver.findElement(By.xpath("//h3[contains(text(),'Help')]")).isDisplayed()==true)
		{
			System.out.println("Help Menu is displayed");
		}
		
		driver.findElement(By.xpath("//li[2]//button[1]//div[1]//*[local-name()='svg']")).click();
		if(driver.findElement(By.xpath("//input[@id='queryInput']")).isDisplayed()==true)
		{
			System.out.println("Search Menu is displayed");
		}
		
			driver.quit();

	}

}
