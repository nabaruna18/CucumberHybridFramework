package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Pages.AccountSuccessPage;
import Pages.HomePage;
import Pages.RegisterPage;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Register {
	
WebDriver driver;
HomePage homePage;
private RegisterPage registerPage;
private AccountSuccessPage accountSuccessPage;
private CommonUtils commonutils;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickRegisterOption();
	}

	@When("User enters the below fields")
	public void user_enters_the_below_fields(DataTable dataTable) {
	   Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	   registerPage.enterFirstName(dataMap.get("firstName"));
	   registerPage.enterLastName(dataMap.get("lastName"));
	   commonutils = new CommonUtils();
	   registerPage.enterEmailAddress(commonutils.getEmailTimeStamp());
	   registerPage.enterTelephone(dataMap.get("telephone"));
	   registerPage.enterPassword(dataMap.get("password"));
	   registerPage.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User enters the below fields with duplicate email")
	public void User_enters_the_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		registerPage.enterFirstName(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmailAddress(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("password"));
		
	}
	
	@When("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerPage.selectPrivacyPolicyOption();
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		accountSuccessPage = registerPage.clickOncontinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	    Assert.assertEquals("Your Account Has Been Created!",accountSuccessPage.getPageHeading());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.selectYesNewsLetterOption();
	}

	@Then("User should get a proper warning message about duplicate email")
	public void user_should_get_a_proper_warning_message_about_duplicate_email() {
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User does not enter any details into any fields")
	public void user_does_not_enter_any_details_into_any_fields() {
		
	}

	@Then("User should get a proper warning message for every mandatory fields")
	public void user_should_get_a_proper_warning_message_for_every_mandatory_fields() {
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarningText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarningText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarningText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarningText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarningText());
	}

}
