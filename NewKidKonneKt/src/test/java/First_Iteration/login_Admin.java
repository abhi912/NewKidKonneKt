package First_Iteration;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class login_Admin {

	public WebDriver driver;
	
	public static void main(String[] args) {}
	
	@BeforeTest
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Setup\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void validationoffileds()
	{
		driver.get("http://app.kidkonnect.in/siteadmin/default.aspx?SID=OTY=");
		String exp_length="50";
		String length = driver.findElement(By.xpath("//*[@id='txtUserNm']")).getAttribute("maxlength");
		System.out.println("Max lenght is "+ length);
		Assert.assertEquals(length, exp_length);
		System.out.println("Test End");
	}
	
	@Test
	public void doLogin()
		{
			driver.get("http://demo.kidkonnect.in/");
			driver.findElement(By.xpath("//*[@id='hypadmin']/img")).click();
			driver.findElement(By.xpath("//*[@id='txtUserNm']")).sendKeys("swami");
			driver.findElement(By.xpath("//*[@id='txtPass']")).sendKeys("20Chaarvi");
			driver.findElement(By.xpath("//*[@id='Button1']")).click();
			driver.findElement(By.xpath("//*[@id='lblUserType']")).click();
			driver.findElement(By.xpath("//*[@id='lblUserType']")).click();
			driver.findElement(By.xpath("//*[@id='aLogout']")).click();
		}
		
	@Test
	public void errorMessage()
	{
			driver.get("http://app.kidkonnect.in/siteadmin/default.aspx?SID=OTY=");
			driver.findElement(By.xpath("//*[@id='Button1']")).click();
			String act_message = driver.findElement(By.xpath("//*[@id='rfvEmailIsReq']")).getText();
			String exp_message="required.";
			Assert.assertEquals(act_message, exp_message);
			String act1_message = driver.findElement(By.xpath("//*[@id='rfvPassIsReq']")).getText();
			Assert.assertEquals(act1_message, exp_message);
			driver.findElement(By.xpath("//*[@id='txtUserNm']")).sendKeys("qwerty");
			driver.findElement(By.xpath("//*[@id='txtPass']")).sendKeys("qwerty");
			driver.findElement(By.xpath("//*[@id='Button1']")).click();
			String actlog_msg = driver.findElement(By.xpath("//*[@id='lblErr']")).getText();
			assertEquals(actlog_msg,"Invalid Username or Password.");
	}

}
