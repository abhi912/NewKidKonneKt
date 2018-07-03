package Regression;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testBase.TestBase;

public class Test_Staff extends TestBase
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
			
			@Test(priority=1) //Verify Add record functionality with valid data
			public void add_Staff()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.type("add_Firstname_Link","add_Staff_Name_First");
				TestBase.type("add_Lasttname_Link","add_Staff_Name_Last");
				TestBase.type("add_MobNo._Link","add_Staff_Mob_No");
				TestBase.type("add_Email_Link","add_Staff_Email_Id");
				TestBase.selectDropdown("add_Designation_Link", "add_Staff_DropDown");
				TestBase.click("add_Button_Link");
				Reporter.log("=== Staff Add Successfully ===",true);
				TestBase.click("add_Staff_Exit");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test(priority=1) //Verify fields present on page
			public void add_Staff_Fields()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.verifyText("add_Stf_Label0", "Stf_Label0");			
				TestBase.verifyText("add_Stf_Label1", "Stf_Label1");
				TestBase.verifyText("add_Stf_Label2", "Stf_Label2");
				TestBase.verifyText("add_Stf_Label3", "Stf_Label3");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test(priority=2) //Verify Labels  present on page
			public void add_Staff_Lable()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.verifyText("add_Stf_Label4", "Stf_Label4");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test(priority=3) //Verify Buttons and Link functionality
			public void add_Staff_Button_Chk()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.type("add_Firstname_Link","add_Staff_Name_First");
				TestBase.type("add_Lasttname_Link","add_Staff_Name_Last");
				TestBase.type("add_MobNo._Link","add_Staff_Mob_No");
				TestBase.type("add_Email_Link","add_Staff_Email_Id");
				TestBase.click("add_Stf_ClrBtn");
				TestBase.txtCheck("add_Firstname_Link");
				TestBase.txtCheck("add_Lasttname_Link");
				TestBase.txtCheck("add_MobNo._Link");
				TestBase.txtCheck("add_Email_Link");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test(priority=4) //Verify Mandatory fields and  Error message
			public void add_Staff_Mandatory()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.click("add_Stf_Submit");
				TestBase.verifyText("add_Stf_Mad_Fname", "add_Staff_MandMsg");
				TestBase.verifyText("add_Stf_Mad_Lname", "add_Staff_MandMsg");
				TestBase.verifyText("add_Stf_Mad_Phno", "add_Staff_MandMsg");
				TestBase.verifyText("add_Stf_Mad_Designation", "add_Staff_MandMsg");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test(priority=5) // Verify check box functionality
			public void add_Staff_chkBox()
			{
				TestBase.click("staff_Link");
				TestBase.click("add_staff_Link");
				TestBase.type("add_Stf_Curnt_Add", "add_Staff_CurrentAddress");
				TestBase.checkBox("add_stf_ChkBox");
				TestBase.verifyTextboxValue("add_Stf_Permnt_Add", "add_Staff_CurrentAddress");
				TestBase.click("lnk_Dashboard");
			}
			
			@Test
			public void edit_Staff()
			{
				TestBase.click("staff_Link");
				TestBase.click("edit_Stf_Link");
				TestBase.type("edit_Stf_SearchBox", "Staff_Name");
				TestBase.click("edit_Stf_SearchButton");
				TestBase.click("edit_Stf_EditIcon");
				TestBase.type("edit_Stf_MiddleName", "Staff_MiddleName");
				TestBase.type("edit_Stf_LastName", "Staff_LasrName");
				TestBase.click("edit_Stf_EditButton");
				Reporter.log(" === Staff Edit Success === ",true);
				TestBase.click("lnk_Dashboard");
			}
}
			