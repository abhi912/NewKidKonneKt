package Regression;

import org.testng.Reporter;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_Login extends TestBase
{
	@Test
	public void adm_Login()
	{
		//TestBase.startApplication("url_Home");
		startApplication("url_Home");
		click("adm_link");
		type("adm_un","un_Admin");
		type("adm_pw","pw_Admin");
		click("adm_clk");
		Reporter.log("=== Admin Login Success ===",true);
		//clearCache();
	}
	
	/*@Test
	public void stf_Login()
	{
		startApplication("url_Home");
		click("stf_link");
		type("stf_un","un_Staff");
		type("stf_pw","pw_Staff");
		click("stf_clk");
		Reporter.log("=== Staff Login Success ===",true);
		clearCache();
	}*/
	
	@Test
	public void std_Login()
	{
		startApplication("url_Home");
		click("prt_link");
		type("prt_un","un_Parent");
		type("prt_pw","pw_Parent");
		click("prt_clk");
		Reporter.log("=== Student Login Success ===",true);
		//clearCache();
	}
	
	@Test
	public void txt_Assert()
	{
		
	}

}
