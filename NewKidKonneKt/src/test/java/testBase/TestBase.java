package testBase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

public class TestBase 

{
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	
	@BeforeSuite
	public static void setUp()
	{
		// Intialization of Properties(Config) File
		try 
		{
		File src = new File("./Properties\\Config.properties");
		FileInputStream fis = new FileInputStream(src);
		Config.load(fis);
		Reporter.log("=== Config Properties File Loaded ===",true);
		/*Config = new Properties();
		Config.load(fis);*/
		} 
		catch (Exception e) 
		{
			System.out.println("Exception Details are "+ e.getMessage());
		}
		
		//Intialization of Properties(OR) File
		try {
		File src = new File("./Properties\\OR.properties");
		FileInputStream fis = new FileInputStream(src);
		OR.load(fis);
		Reporter.log("=== OR Properties File Loaded ===",true);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception Details are "+ e.getMessage());
		}
		
		// Browser Initialization
		if(Config.getProperty("browser").equals("firefox"))
		{
			Reporter.log("=== Browser FireFox Started ===",true);
			driver = new FirefoxDriver();
		}
		else if(Config.getProperty("browser").equals("chrome"))
		{
			Reporter.log("=== Browser Chrome Started ===",true);
			System.setProperty("webdriver.chrome.driver", Config.getProperty("chromeDriverpath"));
			driver = new ChromeDriver();
		}
		else if(Config.getProperty("browser").equals("ie"))
		{
			Reporter.log("=== Browser InternetExplorer Started ===",true);
			System.setProperty("webdriver.ie.driver", Config.getProperty("ieDriverpath"));
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("impliciteWait")), TimeUnit.SECONDS);
	}
	
	public static void startApplication(String url)
	{
		Reporter.log("=== Application Started ===",true);
		driver.get(Config.getProperty(url));
	}
	
	public static void type(String locator, String value)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(Config.getProperty(value));
	}
	
	public static void click(String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
	
	public static void actionToPerform(String locator)
	{
		WebElement element = driver.findElement(By.xpath(OR.getProperty(locator)));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();		
	}
	
	public static void javaScriptScroll()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		//jse.executeScript("scroll(250, 0)"); // if the element is on top.

		jse.executeScript("scroll(0, 300)"); // if the element is on bottom.
	}
	
	/*public static void javaScriptFocus(String locator)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript ("document.getElementById(OR.getProperty(locator))).focus()");
	}*/
	
	public static void pickDate(String locator, String value)
	{
		WebElement datePicker= driver.findElement(By.xpath(OR.getProperty(locator)));
		datePicker.sendKeys(Config.getProperty(value));
	}
	
	public static void pickNextDate (String calendarLink, String buttonLink, String dateSelect, String date) throws InterruptedException
	{
		driver.findElement(By.xpath(OR.getProperty(calendarLink))).click();
		driver.findElement(By.xpath(OR.getProperty(buttonLink))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(OR.getProperty(dateSelect))).click();
		/*WebElement datewidgets = driver.findElement(By.xpath(OR.getProperty(dateSelect)));
		List<WebElement> rows=datewidgets.findElements(By.tagName("tr"));  
		List<WebElement> columns=datewidgets.findElements(By.tagName("td"));
		
		Thread.sleep(5000);
		
		for(WebElement cell : columns)
		{
			if(cell.getText().equals(Config.get(date)))
			{
				cell.findElement(By.xpath(Config.getProperty(date))).click();
				break;
			}
		}*/
	}
		
	public static void alertHandleOK()
	{
		driver.switchTo().alert().accept();
	}
	
	public static void alertHandleCancle()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void clearCache()
	{
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed(link);
	}
	
	public static void clearText(String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).clear();
	}
	
	public static void verifyText(String locator, String value )
	{
		String act_msg= driver.findElement(By.xpath(OR.getProperty(locator))).getText().trim();
		assertEquals(act_msg, Config.getProperty(value));
		System.out.println("Actual Text is " + act_msg + " and Expected Text is "+ Config.getProperty(value) );
		Reporter.log("=== Verify Text Sucess ===",true);
	}
	
	public static void verifyTextboxValue(String locator, String value )
	{
		String act_msg= driver.findElement(By.xpath(OR.getProperty(locator))).getAttribute("value").toString();
		assertEquals(act_msg, Config.getProperty(value));
		System.out.println("Actual Message is " + act_msg );
		Reporter.log("=== Verify Text Sucess ===",true);
	}
	
	public static void txtCheck(String locator)
	{
		if(driver.findElement(By.xpath(OR.getProperty(locator))).getText().isEmpty())
		{
		   System.out.println("Input field is empty");
		}
	}
	
	public static void selectDropdown(String locator, String value)
	{
		/*Select oSelect =  new Select((WebElement) driver.findElements(By.xpath(OR.getProperty(locator))));
		oSelect.selectByValue(Config.getProperty(value));*/
		
		Select sel = new Select(driver.findElement(By.xpath(OR.getProperty(locator))));
	    sel.selectByVisibleText(Config.getProperty(value));
	}
	
	public static void checkBox(String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
	}
	
	public static void datePicker(String locator, String value)
	{
		
	}
	
	public static void checkBoxSelction(String locator)
	{
		if(driver.findElement(By.xpath(OR.getProperty(locator))).isSelected())
		{
			System.out.println("checkbox is already selected");
		}
		else
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			System.out.println("checkbox is now selected");
		}
	}
	
	/*public void newTab()
	{
		String openNewTab = Keys.chord(Keys.CONTROL,"t");
		driver.findElement(By.linkText(Config.getProperty("url_Home"))).sendKeys(openNewTab);
	}*/
	
	public static void tabClose()
	{
		//Thread.sleep(2000);
		Reporter.log("=== Tab Session End ===",true);
		driver.close();
	}
	
	public static void tearDown()
	{
		Reporter.log("=== Browser Session End ===",true);
		driver.quit();
	}
}
