package Regression;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_Fees extends TestBase
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
		TestBase.click("feesLink");
		TestBase.verifyText("feesLable1", "fees_Lable1");
		TestBase.verifyText("feesLable2", "fees_Lable2");
		TestBase.verifyText("feesLable3", "fees_Lable3");
		TestBase.verifyText("feesLable4", "fees_Lable4");
		TestBase.verifyText("feesLable5", "fees_Lable5");
		TestBase.verifyText("feesLable6", "fees_Lable6");
		TestBase.verifyText("feesLable7", "fees_Lable7");
		TestBase.verifyText("feesLable8", "fees_Lable8");
		TestBase.verifyText("feesLable9", "fees_Lable9");
		Reporter.log("=== Sub-Menu Lable Verify Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyAddCategory()
	{
		TestBase.click("feesLink");
		TestBase.click("Fees_Category_Link");
		TestBase.click("Fees_Category_TextInput");
		TestBase.type("Fees_Category_TextInput", "Fees_Category");
		TestBase.click("Fees_Category_Add_Btn");
		Reporter.log("=== Fee Category Added Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifySelectAllChkBox()
	{
		TestBase.click("feesLink");
		TestBase.click("Fees_Category_Link");
		TestBase.click("Fees_Category_SelectAll_ChkBox");
		TestBase.click("Fees_Category_SelectAll_ChkBox");
		Reporter.log("=== Select All Chk Box Verify Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyCategoryDelete()
	{
		TestBase.click("feesLink");
		TestBase.click("Fees_Category_Link");
		TestBase.click("Fees_Category_ChkBox");
		TestBase.javaScriptScroll();
		TestBase.actionToPerform("Fees_Category_Delete_Btn");
		TestBase.alertHandleOK();
		Reporter.log("=== Fee Category Delete Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyCategoryEdit()
	{
		TestBase.click("feesLink");
		TestBase.click("Fees_Category_Link");
		TestBase.click("Fees_Category_Edit_Link");
		TestBase.clearText("Fees_Category_Edit_Input");
		TestBase.type("Fees_Category_Edit_Input", "Fees_Category_Edit");
		TestBase.click("Fees_Category_Update_Btn");
		Reporter.log("=== Fee Category Edit Success ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyExportExcelAll()
	{
		TestBase.click("feesLink");
		TestBase.click("Pending_Fee_Report_Link");
		TestBase.click("Pending_Fee_Report_ExportExcel_Btn");
		//TestBase.alertHandleOK();
		Reporter.log("=== Excel Report Download ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	/*@Test
	public void verifyExportExcelCancle()
	{
		TestBase.click("feesLink");
		TestBase.click("Pending_Fee_Report_Link");
		TestBase.click("Pending_Fee_Report_ExportExcel_Btn");
		TestBase.alertHandleCancle();
		Reporter.log("=== Excel Report Download Cancle ===",true);
		TestBase.click("lnk_Dashboard");
	}*/
	
	@Test
	public void verifyExportExcelbyClassDiv()
	{
		TestBase.click("feesLink");
		TestBase.click("Pending_Fee_Report_Link");
		TestBase.selectDropdown("Pending_Fee_Report_Class_Dropdown", "Pending_Report_Class");
		TestBase.selectDropdown("Pending_Fee_Report_Div_Dropdown", "Pending_Report_Div");
		TestBase.click("Pending_Fee_Report_ExportExcel_Btn");
		//TestBase.alertHandleOK();
		Reporter.log("=== Excel Report Download by Class and Division ===",true);
		TestBase.click("lnk_Dashboard");
	}
	
	@Test
	public void verifyExportExcelbyStudent()
	{
		TestBase.click("feesLink");
		TestBase.click("Pending_Fee_Report_Link");
		TestBase.type("Pending_Fee_Report_SearchbyStudent", "Pending_Report_Student");
		TestBase.click("Pending_Fee_Report_Search_Btn");
		TestBase.click("Pending_Fee_Report_ExportExcel_Btn");
		//TestBase.alertHandleOK();
		Reporter.log("=== Excel Report Download by Student Name ===",true);
		TestBase.click("lnk_Dashboard");
	}
}
