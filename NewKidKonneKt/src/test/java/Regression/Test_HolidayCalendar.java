package Regression;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_HolidayCalendar extends TestBase
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
	public void verifyFieldsLable()
	{
		TestBase.click("holiCalLink");
		TestBase.verifyText("holiCalTitle", "HolidayCalTitle");
		TestBase.verifyText("holiCalLable1", "HolidayCalLable1");
		TestBase.verifyText("holiCalLable2", "HolidayCalLable2");
		TestBase.verifyText("holiCalLable3", "HolidayCalLable3");
		TestBase.verifyText("holiCalLable4", "HolidayCalLable4");
		Reporter.log("=== Field Lable Verify Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyAddHoliday() throws InterruptedException
	{
		TestBase.click("holiCalLink");
		TestBase.click("holidayAddLink");
		TestBase.type("holidayTitle", "Holiday_Title");
		TestBase.pickNextDate("holidayStartDate", "holidayStartCalendarNextBtn", "holidayStartDateSelect", "Holiday_Start_Date");
		TestBase.pickNextDate("holidayEndDate", "holidayEndCalendarNextBtn", "holidayEndDateSelect", "Holiday_End_Date");
		TestBase.click("holidayAddButton");
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyDeleteHoliday()
	{
		TestBase.click("holiCalLink");
		TestBase.click("holidayDeleteLink");
		TestBase.click("holidayDeleteChkBox");
		TestBase.javaScriptScroll();
		TestBase.actionToPerform("holidayDeleteButton");
		TestBase.alertHandleOK();
		Reporter.log("=== Holiday Delete Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifySelectAllChkBox()
	{
		TestBase.click("holiCalLink");
		TestBase.click("holidayDeleteLink");
		TestBase.click("holidaySelectAllChkBoxDelete");
		TestBase.click("holidaySelectAllChkBoxDelete");
		Reporter.log("=== Select All Chk Box Verify Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifySearchHoliday()
	{
		TestBase.click("holiCalLink");
		TestBase.click("holidaySearchLink");
		//TestBase.javaScriptFocus("holidaySearchBoc");
		TestBase.type("holidaySearchBoc", "Holiday_Search");
		TestBase.click("holidaySearchButton");
		Reporter.log("=== Holiday Search Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
}
