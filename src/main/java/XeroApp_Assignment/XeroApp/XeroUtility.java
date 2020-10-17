package XeroApp_Assignment.XeroApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XeroUtility extends TestBase1 {
	static WebDriver driver;
	public static WebDriver LaunchBrowser(String BrowserName) {
		switch (BrowserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			break;

		default:
			break;
		}
		
		return driver;
	}
	
	public static void LogintoWebsite(String sEmailID ,String spassword) throws Exception {
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		driver.get("https://www.xero.com/us/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Username']")).click();
		driver.findElement(By.xpath("//input[@name='Username']")).clear();
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys(sEmailID);
		
		driver.findElement(By.xpath("//input[@name='Password']")).click();
		driver.findElement(By.xpath("//input[@name='Password']")).clear();
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(spassword);
		
		driver.findElement(By.xpath("//button[@value='login']")).click();
	}
	
	/*public void ExplicitWaitFunc(WebElement ele,int iTime) {
		WebDriverWait wait=new WebDriverWait(driver, iTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void PrintListofWebElements(List<WebElement> ListfWebElemnts )
	{
		for(int count=0;count<ListfWebElemnts.size();count++) {
			System.out.print(ListfWebElemnts.get(count).getText()+"\t");
		}
		System.out.println();
	}*/
	
	public static void ExplicitWaitFunc(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void ExitBrowser() {
		driver.quit();
	}
	
	public static void IsHomePageDisplayed(WebElement ele) {
		boolean homedisplayed=ele.isDisplayed();
		if(homedisplayed=true) {
			System.out.println("Home page is displayed Test is sucessfully passed");
		}else
			System.out.println("Test is failed");
	}
	
	public static void VerifyUserError(WebElement ele,String sErrorMsg) throws Exception {
		Thread.sleep(5000);
		String Errormsg=ele.getText();
		System.out.println(Errormsg);
		if(Errormsg.equals(sErrorMsg))
		{
			System.out.println("Error msg is displayed TestCase is Pass");
		}else
			System.out.println("TestCase is Fail");
	}
	
	public void ufClickElement(WebElement ele) {
		
		ele.click();
	}
	
	public void ufClearElement(WebElement ele) {
		ele.clear();
	}
	
	public boolean ufVerifyFieldisDisplayed(WebElement ele) {
		
		return ele.isDisplayed();
	}

	public void ufSenKeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	
}

