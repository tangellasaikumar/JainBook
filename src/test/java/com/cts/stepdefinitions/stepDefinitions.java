package com.cts.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cts.Base.LaunchWebDriver;
import com.cts.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {
	WebDriver driver;

	@Given("I have browser with  JainBookAgencyPage")
	public void i_have_browser_with_JainBookAgencyPage() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jainbookagency.com/india-largest-online-book-store.aspx");
	}

	@When("I enter <validmailId> as {string} ,I enter <repeatEmailAddress> as {string}, I enter <validpassword> as {string} and I enter <Repeat Password> as {string}")
	public void i_enter_validmailId_as_I_enter_repeatEmailAddress_as_I_enter_validpassword_as_and_I_enter_Repeat_Password_as(
			String mail, String mailid1, String password, String password1) throws InterruptedException {

		HomePage.ClickOnLogin(driver);

		HomePage.ClickOnSignUp(driver);

		Thread.sleep(1000);

		HomePage.enterEmailId(driver, mail);

		HomePage.enterPassword(driver, password);

		HomePage.reEnterEmailId(driver, mailid1);

		HomePage.reEnterPassword(driver, password1);

		HomePage.ClickOnSignUpNow(driver);
	}

	@Then("I should create an account successfully.")
	public void i_should_create_an_account_successfully() {
		HomePage.signinMessage(driver);
	}

	@When("I enter <invalidmailId> as {string} ,I enter <repeatEmailAddress> as {string}, I enter <password> as {string} and I enter <Repeat Password> as {string}")
	public void i_enter_invalidmailId_as_I_enter_repeatEmailAddress_as_I_enter_password_as_and_I_enter_Repeat_Password_as(
			String userName1, String password1, String mailid11, String password11) {

		HomePage.ClickOnLogin(driver);

		HomePage.ClickOnSignUp(driver);

		HomePage.enterEmailId(driver, userName1);

		HomePage.enterPassword(driver, password1);

		HomePage.reEnterEmailId(driver, mailid11);

		HomePage.reEnterPassword(driver, password11);

		HomePage.ClickOnSignUpNow(driver);

	}

	@Then("I should get a error message")
	public void i_should_get_a_error_message() {
		HomePage.invalidMessage(driver);
	}

	@When("I enter <mailId> as {string} ,I enter <validpassword> as {string}")
	public void i_enter_mailId_as_I_enter_validpassword_as(String email, String password) {
		HomePage.ClickOnLogin(driver);
		HomePage.enteringLoginEmail(driver, email);
		HomePage.enteringLoginPassword(driver, password);
		HomePage.clickingValidLogin(driver);

	}

	@Then("I should login successfully and  search for books.")
	public void i_should_login_successfully_and_search_for_books() {
		String expectedTitle = "India's Largest Online Book Store";
		String actualTitle = driver.getTitle().trim();
		Assert.assertEquals("Assertion Failed", expectedTitle, actualTitle);
	}

	@When("I enter <invalidmailId> as {string} , I enter <password> as {string}")
	public void i_enter_invalidmailId_as_I_enter_password_as(String email, String password) {
		HomePage.ClickOnLogin(driver);
		HomePage.enteringLoginEmail(driver, email);
		HomePage.enteringLoginPassword(driver, password);
		HomePage.clickingValidLogin(driver);
	}

	@Then("I should get a invalid mailId message displayed as {string}")
	public void i_should_get_a_invalid_mailId_message_displayed_as(String expectedText) {
		String actualText = "Unable To Login: Email/Password Is Invalid";
		Assert.assertEquals("Assertion Failed", expectedText, actualText);
	}

	@When("I enter <mailId> as {string} , I enter <invalidpassword> as {string}")
	public void i_enter_mailId_as_I_enter_invalidpassword_as(String email, String password) {
		HomePage.ClickOnLogin(driver);
		HomePage.enteringLoginEmail(driver, email);
		HomePage.enteringLoginPassword(driver, password);
		HomePage.clickingValidLogin(driver);
	}

	@Then("I should get a inValid password  message displayed as {string}")
	public void i_should_get_a_inValid_password_message_displayed_as(String expectedText) {
		String actualText = "Unable To Login: Email/Password Is Invalid";
		Assert.assertEquals("Assertion Failed", expectedText, actualText);
	}
}
