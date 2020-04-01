package com.cts.stepdefinitions;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.cts.base.LaunchWebBrowser;
import com.cts.pages.HomePage;
import com.cts.utils.ReadExcel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {
	WebDriver driver;

	@Given("I have browser with  JainBookAgencyPage")
	public void i_have_browser_with_JainBookAgencyPage() {

		//launch webdriver
				LaunchWebBrowser.LaunchWebDriver("ch");
				this.driver = LaunchWebBrowser.driver;
	}

@When("I enter details from excel {string} with sheet name {string}")
public void i_enter_details_from_excel_with_sheet_name(String filedetails, String sheetname) throws InterruptedException, IOException {
	
	String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/jain books.xlsx","sign up");
	
	HomePage login = new HomePage(driver);
	
	login.ClickOnLogin();

	login.ClickOnSignUp();

		Thread.sleep(1000);

		login.enterEmailId(str[0][0]);

		login.enterPassword(str[0][2]);

		login.reEnterEmailId(str[0][1]);

		login.reEnterPassword(str[0][3]);

		login.ClickOnSignUpNow();
	}

	@Then("I should create an account successfully.")
	public void i_should_create_an_account_successfully() throws InterruptedException {
		HomePage login = new HomePage(driver);
		login.signinMessage();
		LaunchWebBrowser.exit();
	}

@When("I enter  invalid details from excel {string} with sheet name {string}")
public void i_enter_invalid_details_from_excel_with_sheet_name(String filedetails, String sheetname) throws IOException {

	String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/jain books.xlsx","invalid sign up");
	
	HomePage login = new HomePage(driver);

	login.ClickOnLogin();

	login.ClickOnSignUp();

	login.enterEmailId(str[0][0]);

	login.enterPassword(str[0][0]);

	login.reEnterEmailId(str[0][0]);

	login.reEnterPassword(str[0][0]);

	login.ClickOnSignUpNow();

	}

	@Then("I should get a error message")
	public void i_should_get_a_error_message() {
		HomePage login = new HomePage(driver);
		login.invalidMessage();
	}


@When("I enter valid details from excel {string} with sheet name {string}")
public void i_enter_valid_details_from_excel_with_sheet_name(String filedetails, String sheetname) throws IOException {
	String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/jain books.xlsx","valid login");
	
	HomePage login = new HomePage(driver);
	
	login.ClickOnLogin();
	login.enteringLoginEmail(str[0][0]);
	login.enteringLoginPassword(str[0][1]);
	login.clickingValidLogin();

	}

	@Then("I should login successfully and  search for books.")
	public void i_should_login_successfully_and_search_for_books() {
		
		String expectedTitle = "India's Largest Online Book Store";
		String actualTitle = driver.getTitle().trim();
		Assert.assertEquals("Assertion Failed", expectedTitle, actualTitle);
	}

	@When("I enter invalid details from excel {string} with sheet name {string}")
	public void i_enter_invalid_mail_from_excel_with_sheet_name(String filedetails, String sheetname) throws IOException {
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/jain books.xlsx","invalid login");
		
		HomePage login = new HomePage(driver);
		
		login.ClickOnLogin();
		login.enteringLoginEmail(str[0][0]);
		login.enteringLoginPassword(str[0][1]);
		login.clickingValidLogin();
	}

	@Then("I should get a invalid mailId message displayed as {string}")
	public void i_should_get_a_invalid_mailId_message_displayed_as(String expectedText) {
		String actualText = "Unable To Login: Email/Password Is Invalid";
		Assert.assertEquals("Assertion Failed", expectedText, actualText);
	}

	@When("I enter invalid details from excel {string} with sheet name {string}")
	public void i_enter_invalid_password_from_excel_with_sheet_name(String filedetails, String sheetname) throws IOException {
		String str[][] = ReadExcel.getSheetIntoStringArray("src/test/resources/excel/jain books.xlsx","invalid login");
		
		HomePage login = new HomePage(driver);
		
		login.ClickOnLogin();
		login.enteringLoginEmail(str[1][0]);
		login.enteringLoginPassword(str[1][1]);
		login.clickingValidLogin();
	}

	@Then("I should get a inValid password  message displayed as {string}")
	public void i_should_get_a_inValid_password_message_displayed_as(String expectedText) {
		String actualText = "Unable To Login: Email/Password Is Invalid";
		Assert.assertEquals("Assertion Failed", expectedText, actualText);
	}
}
