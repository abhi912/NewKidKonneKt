package Regression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo
{
	@Test
	public void TestDate()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\user1\\workspace\\KidKonnect\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(".//*[@id='datepicker']")).click();;
		driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		
		WebElement datewidgets = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']"));
		List<WebElement> rows=datewidgets.findElements(By.tagName("tr"));  
		List<WebElement> columns=datewidgets.findElements(By.tagName("td"));
		
		for(WebElement cell : columns)
		{
			if(cell.getText().equals("13"))
			{
				cell.findElement(By.linkText("13")).click();
				break;
			}
		}
		
		
		
	}
	
	
}
