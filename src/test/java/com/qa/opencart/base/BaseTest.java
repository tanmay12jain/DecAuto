package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterationPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.pages.ShoppingCartPage;

import io.qameta.allure.Step;

public class BaseTest {

	WebDriver driver;
	protected Properties prop;
	DriverFactory df;

	protected SoftAssert softAssert;
	protected ShoppingCartPage shoppingCartPage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterationPage registerationPage;
	protected LoginPage loginPage; // we dont want any one access that but we can access on different package with
									// extention of this class
	// in public any any one access it so we dont want this.

	@Step("Launching the {0} browser and initializing the properties")
	@Parameters({ "browser" })
	@BeforeTest
	//public void setup(@Optional("chrome")String BrowserName) {
		public void setup(String BrowserName) {
		df = new DriverFactory();
		prop = df.initProp();// we have to initialize prop to get the all properties from the file in prop
								// reference
		if (BrowserName != null) {
			prop.setProperty("browser", BrowserName);
		}

		driver = df.initDriver(prop);// call by reference, we are passing properties class reference 'prop' to
										// deriver initilaization3
		loginPage = new LoginPage(driver);// mantaing login page reference to use in the tests
		softAssert = new SoftAssert();
//		accPage=new AccountsPage(driver);
//		searchResultsPage=new SearchResultsPage(driver);
	}
	
	@Step("Closing the browser")
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
