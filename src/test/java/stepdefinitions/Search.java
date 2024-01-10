package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.HomePage;
import Pages.SearchResultPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	    driver = DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProductText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearhBox(validProductText);
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchResultPage = homePage.clickOnSearchButton();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	    Assert.assertTrue(searchResultPage.displayStatusOfValidProduct());
	}
	
	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProductText) {
		homePage = new HomePage(driver);
		homePage.enterProductIntoSearhBox(invalidProductText);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {;
	   Assert.assertEquals("There is no product that matches the search criteria.", searchResultPage.getMessageText());
	}

	@When("User does not enter any product into the search box field")
	public void user_does_not_enter_any_product_into_the_search_box_field() {
		homePage = new HomePage(driver);
	}

}
