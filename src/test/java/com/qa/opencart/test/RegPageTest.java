package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

import io.qameta.allure.Step;

public class RegPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerationPage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] {
			{"gaurav", "gupta",  "9876543212", "gg@123", "yes"},
			{"shilpa", "mamiidipelli", "9876543662", "shilpa@123", "no"},
			{"om", "gautam", "9876587653", "om@123", "yes"}

		};
	}	
	
	
//	@DataProvider
//	public Object[][] getUserRegTestDataFromExcel() {
//		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
//	}
	
	
	@DataProvider
	public Object[][] getUserRegTestDataFromCSV() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}

	
	//@Test(dataProvider = "getUserRegTestData")
	@Step("Checking for the user registration")
	@Test(dataProvider ="getUserRegTestDataFromCSV" )
	public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {
		Assert.assertTrue(
				registerationPage.userRegister(firstName, lastName, 
						StringUtils.getRandomEmailId(), 
						telephone, password, subscribe));

	}
	
	

}
