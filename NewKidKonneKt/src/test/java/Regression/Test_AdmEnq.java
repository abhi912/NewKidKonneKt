package Regression;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_AdmEnq extends TestBase 
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
	public void verifySubMenuLable()
	{
		TestBase.click("admEnq_Link");
		TestBase.verifyText("admEnq_Lable1", "admEnq_Lable1");
		TestBase.verifyText("admEnq_Lable2", "admEnq_Lable2");
		TestBase.verifyText("admEnq_Lable3", "admEnq_Lable3");
		TestBase.verifyText("admEnq_Lable4", "admEnq_Lable4");
		TestBase.verifyText("admEnq_Lable5", "admEnq_Lable5");
		Reporter.log("=== Field Lable Verify Success ===",true);
		TestBase.click("lnk_Dashboard");
		//TestBase.tabClose();
	}
	
	@Test
	public void verifyAddVisitor() throws InterruptedException
	{
		TestBase.click("admEnq_Link");
		TestBase.click("AdmEnqAddVisitor");
		TestBase.checkBox("admEnqRadioBtn");
		TestBase.selectDropdown("admEnqDropDown", "admDropDown");
		Thread.sleep(3000);
		TestBase.type("admEnqFatherName", "Fathersname");
		TestBase.type("admEnqMotherName", "Mothersname");
		TestBase.type("admEnqChildName", "Childsname");
		TestBase.type("admEnqAddress", "Address");
		TestBase.pickNextDate("admEnqDOBCalendar", "admEnqDOBCalendarNextBtn", "admEnqDateSelect", "DOB");
		//TestBase.type("admEnqDOB", "DOB");
		//TestBase.pickDate("admEnqDOB", "DOB");
		//TestBase.type("admEnqFollowup", "NextFollowUp");
		//TestBase.pickDate("admEnqFollowup", "NextFollowUp");
		TestBase.type("admEnqMobileno", "Mobilenumber");
		TestBase.selectDropdown("admEnqSex", "Sex");	
		TestBase.click("admEnqSubmit");
		Reporter.log("=== Visitor Added Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyExportExcelOk()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqViewVisitor");
		TestBase.click("admEndSelectAllChkBox");
		TestBase.click("admEnqExportExcel");
		TestBase.alertHandleOK();
		Reporter.log("=== Excel Report Download ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyExportExcelCancle()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqViewVisitor");
		TestBase.click("admEndSelectAllChkBox");
		TestBase.click("admEnqExportExcel");
		TestBase.alertHandleCancle();
		Reporter.log("=== Excel Report Download Cancle ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifySearchByName()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqViewVisitor");
		TestBase.type("admEnqSearchByName", "SearchByName");
		TestBase.click("admEnqSearchButton");
		Reporter.log("=== Result Search by Name Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void deleteVisitorOk()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqViewVisitor");
		TestBase.click("admEnqDeleteVisitor");
		TestBase.alertHandleOK();
		Reporter.log("=== Visitor Record Deleted ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void deleteVisitorCancle()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqViewVisitor");
		TestBase.click("admEnqDeleteVisitor");
		TestBase.alertHandleCancle();
		Reporter.log("=== Visitor Record Deleted Cancelled ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void visitorCategoryAdd()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqCategory");
		TestBase.type("admEnqCategoryAdd", "CategoryText");
		TestBase.click("admEnqCategorySubmit");	
		Reporter.log("=== Visitor Category Added Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void visitorCategoryDelete()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqCategory");
		TestBase.click("admEnqCategoryChkBox");
		TestBase.click("admEnqCategoryDelete");
		Reporter.log("=== Visitor Category Deleted ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void visitorCategoryEdit()
	{
		TestBase.click("admEnq_Link");
		TestBase.click("admEnqCategory");
		TestBase.click("admEnqCategoryEdit");
		TestBase.type("admEnqCategoryEditTextbox", "CategoryUpdateText");
		TestBase.click("admEnqCategoryUpdate");
		Reporter.log("=== Visitor Category Updated ===",true);
		TestBase.click("lnk_Dashboard");
	}
}
