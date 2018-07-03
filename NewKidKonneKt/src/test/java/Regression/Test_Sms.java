package Regression;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_Sms extends TestBase
{
	@BeforeClass
	public void login()
	{
	TestBase.startApplication("url_Home");
	TestBase.click("adm_link");
	TestBase.type("adm_un","un_Admin");
	TestBase.type("adm_pw","pw_Admin");
	TestBase.click("adm_clk");
	Reporter.log("=== Admin Login Success ===",true);
	//clearCache();
	}
	
	@Test
	public void smsToAllCheckboxTest()
	{
		TestBase.click("sms_Link");
		TestBase.click("smsToAll_Link");
		TestBase.checkBox("smsToAll_1ChkBox");
		System.out.println("Primary Number is Unchecked");
		TestBase.checkBox("smsToAll_2ChkBox");
		System.out.println("Secondry Number is Checked");
	}
	
	@Test
	public void smsToAllCheckbox()
	{
		TestBase.click("sms_Link");
		TestBase.click("smsToAll_Link");
		TestBase.checkBoxSelction("smsToAll_1ChkBox");
		TestBase.checkBoxSelction("smsToAll_2ChkBox");
	}
	
	
}
