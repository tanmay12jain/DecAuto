package com.qa.opencart.pages;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class ShoppingCartPage{
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
//	private By subTotal = By.xpath("(//div[@class='col-sm-4 col-sm-offset-8']//td[@class='text-right']/following-sibling::td)[1]");
//	private By Total = By.xpath("(//div[@class='col-sm-4 col-sm-offset-8']//td[@class='text-right']/following-sibling::td)[2]");
	private By ProductName = By.xpath("(//td[@class='text-left']/a)[2]");
	private By quantity = By.xpath("//input[contains(@name, 'quantity')]");
	private By unitPrice = By.xpath("((//table[@class='table table-bordered'])[2]//tbody//td[@class='text-right'])[1]");
	private By totalPrice = By.xpath("((//table[@class='table table-bordered'])[2]//tbody//td[@class='text-right'])[2]");
	private By image = By.xpath("(//img[contains(@src, 'macbook_pro_1') and @alt='MacBook Pro'])[2]");
	private By clearCart = By.xpath("//button[@data-original-title='Remove']");
	
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getshopingcartTitle() {
		String title = eleUtil.waitForTitleContains(AppConstants.SHOPPING_CART_TITLE, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("Title of the page is "+title);
		//String[] actTitle = title.split("×");
		//return actTitle[0];
		clearShopingCart();

		return title;
		
	}
	
	public String shopingCartURL() {
		String urlcart = eleUtil.waitForURLContains(AppConstants.SHOPPING_CART_URL_CONTAIN, TimeUtil.DEFAULT_MEDIUM_TIME);
		return urlcart;
	}
	
	public boolean imagevisible() {
		 WebElement imagevisible = eleUtil.waitForElementVisible(image, TimeUtil.DEFAULT_MEDIUM_TIME);
		return imagevisible.isDisplayed();
	}
	
	public String productName() {
		 return eleUtil.getElement(ProductName).getText();
	}
	
	public String productQuantity() {
		return eleUtil.doElementGetAttribute(quantity, "value");
	}
	
	public String unitPrice() {
		String unitPrices =eleUtil.getElement(unitPrice).getText();
		return unitPrices;
	}
	public String totalPrice() {
		String totalPrices =eleUtil.getElement(totalPrice).getText();
		return totalPrices;
	}
	public void clearShopingCart() {
		eleUtil.doClick(clearCart, TimeUtil.DEFAULT_SHORT_TIME);
		TimeUtil.mediumTime();
	}
	
	
	
	
	

}
