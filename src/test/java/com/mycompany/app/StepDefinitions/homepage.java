package com.mycompany.app.StepDefinitions;

import com.mycompany.app.PageObjects.PageObjects;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

//homepage class extends Hooks class as webdriver driver is defined in Hooks class
public class homepage extends Hooks {
	
	PageObjects po;
	private static Logger logger = LoggerFactory.getLogger (homepage.class);
	
	@BeforeTest
	@Given("^user goes to firefox$")
	public void user_goes_to_firefox () throws Throwable {
		driver = new ChromeDriver ();
		po = new PageObjects (driver);
	}
	
	@Test
	@When("^user goes to the site \"([^\"]*)\"$")
	public void user_goes_to_the_site (String url) throws Throwable {
		driver.get (url);
	}
	
	@Test
	@Then("^check if \"([^\"]*)\" are there in a cart$")
	public void check_if_are_there_in_a_cart (String noProducts) throws Throwable {
		po.selectCart ();
		po.getCartInfo (noProducts);
	}
	
	@Test
	@Then("^go back to the homepage$")
	public void go_back_to_the_homepage () throws Throwable {
		po.goToHomepage ();
	}
	
	@Test
	@Then("^Select a dress$")
	public void select_a_dress () throws Throwable {
		po.getDress ();
	}
	@Test
	@Then("^wait to be visible$")
	public void wait_to_be_visible() throws Throwable {
	}
	
	@Test
	@Then("^add it to the cart$")
	public void add_it_to_the_cart () throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		po.clickOnAddtoCart ();
	}
	
	@Test
	@Then("^check if same \"([^\"]*)\" has been added to the cart$")
	public void check_if_same_has_been_added_to_the_cart (String dress) throws Throwable {
		po.selectCart ();
		Assert.assertEquals (dress, po.getDressName ());
	}
	@Test
	@Then("^click on checkout$")
	public void click_on_checkout () throws Throwable {
		po.clickOnProceedToCheckoutButton ();
	}
	
	@Test
	@Then("^check user is on first \"([^\"]*)\" phase$")
	public void check_user_is_on_first_phase (String summary) throws Throwable {
		po.getSummaryPhaseName ();
	}
	
	@Test
	@Then("^click on proceed to checkout button$")
	public void click_on_proceed_to_checkout_button () throws Throwable {
		po.clickOnProceedToCheckoutButton ();
	}
	
	@Test
	@Then("^check user is on second \"([^\"]*)\" phase$")
	public void check_user_is_on_second_phase (String signIn) throws Throwable {
		po.getSignInPhaseName ();
		po.closeTheBrowser ();
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit ();
	}
	
}
