package com.mycompany.app.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageObjects {
	static WebDriver driver;
	private static Logger logger = LoggerFactory.getLogger (PageObjects.class);
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]" )
	WebElement addToCart;
	
	@FindBy(className = "cart_block_no_products unvisible")
	WebElement emptyCart;
	
	@FindBy(className = "shopping_cart")
	WebElement cart;
	
	@FindBy(id = "header_logo")
	WebElement logo;
	
//	@FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/a[1]/img")
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[3]/div/div[1]/div/a[1]/img")
	WebElement selectedDress;
	
	@FindBy(id = "product_3_13_0_0")
	WebElement dressID;
	
	@FindBy(className = "button btn btn-default standard-checkout button-medium")
	WebElement proceedToCheckout;
	
	@FindBy(className = "step_current second")
	WebElement signInPhase;
	
	@FindBy(className = "step_current  first")
	WebElement summaryPhase;
	
	public PageObjects (WebDriver driver) {
		
		PageObjects.driver = driver;
		PageFactory.initElements (driver, this);
		
	}
	
	
	public void clickOnAddtoCart () {
		addToCart.click ();
	}
	
	public void goToHomepage () {
		logo.click ();
	}
	
	public void selectCart () {
		Actions builder = new Actions (driver);
		builder.moveToElement (cart).build ().perform ();
	}
	
	public void getCartInfo (String info) {
		if (!emptyCart.toString ().equals (info)) {
			logger.info ("cart is not empty");
		}
	}
	
	public void getDress () {
//		Actions actions = new Actions (driver);
//		actions.moveToElement (selectedDress);
		selectedDress.click ();
		
	}

	public String getDressName () {
		return dressID.getText ();
	}
	
	public void clickOnProceedToCheckoutButton () {
		proceedToCheckout.click ();
	}
	
	public String getSignInPhaseName () {
		return signInPhase.getText ();
	}
	
	public String getSummaryPhaseName () {
		return summaryPhase.getText ();
	}
	
	public void closeTheBrowser () {
		driver.quit ();
	}
	
	
}
