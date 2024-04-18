package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.ShoppingCartPage;



public class ShopingCartTest extends BaseTest {
	@BeforeClass
	public void infoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void getTitlep() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeader(), "MacBook Pro");
	}
	
	@Test (priority = 1)
	public void addToCart() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		productInfoPage.addtocartwithQuantity();
		String succMsz = productInfoPage.successMessage();
		Assert.assertEquals(succMsz, AppConstants.SUCCESS_MESSAGE);
		shoppingCartPage = productInfoPage.shoppingCartClick();
		shoppingCartPage.clearShopingCart();

	}
	
	@Test (priority = 2)
	public void shoppingcartTitle() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		productInfoPage.addtocartwithQuantity();
		shoppingCartPage = productInfoPage.shoppingCartClick();
		String title = shoppingCartPage.getshopingcartTitle();
		Assert.assertEquals(title, AppConstants.SHOPPING_CART_TITLE);
		
	}
	
	@Test (priority = 3)
	public void testProdductDetails() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
		productInfoPage.addtocartwithQuantity();
		shoppingCartPage = productInfoPage.shoppingCartClick();
		boolean image = shoppingCartPage.imagevisible();
		String prodName = shoppingCartPage.productName();
		String sQuantity = shoppingCartPage.productQuantity();
		String uPrice = shoppingCartPage.unitPrice();
		String tPrice = shoppingCartPage.totalPrice();
		Assert.assertEquals(prodName, "MacBook Pro");
		softAssert.assertEquals(sQuantity, "2");
		softAssert.assertEquals(uPrice, "$2,000.00");
		softAssert.assertEquals(tPrice, "$4,000.00");
		softAssert.assertTrue(image);
		softAssert.assertAll();
		shoppingCartPage.clearShopingCart();

		
	}
}
