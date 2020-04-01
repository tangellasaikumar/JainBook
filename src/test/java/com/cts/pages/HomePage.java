
package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	

	private By LoginBtnLoc = By.xpath("//a[@id='login']");
	private By SignUpBtnLoc = By.xpath("//input[@id='btnsubmit0']");
	private By enterEmailLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox4']");
	private By reEnterEmailLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox8']");
	private By enterPasswordLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox6']");
	private By reEnterPasswordLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox7']");
	private By SignUpNowBtnLoc = By.xpath("//input[@id='ContentPlaceHolder1_btnsubmit']");
	private By SignUpmsgLoc = By.xpath("//div[contains(text(),'Unable To Login')]");
	private By invalidmsgLoc = By.xpath("//div[contains(text(),'Please Check The Email: Both The Email Do Not Match.')]");
	private By loginEmailLoc = By.xpath("(//input[@id='ContentPlaceHolder1_TextBox1'])[1]");
	private By loginPasswordLoc = By.xpath("(//input[@id='ContentPlaceHolder1_TextBox2'])[1]");
	private By loginLoc = By.xpath("(//input[@id='ContentPlaceHolder1_btnlogin'])[1]");
	private By invalidMailTextLoc = By.xpath("(//div[@class='modal-body'])[3]");
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

//Clicking On Login on the home page
	public void ClickOnLogin() {
		driver.findElement(LoginBtnLoc).click();
	}

//Clicking On SignUp Button
	public void ClickOnSignUp() {
		driver.findElement(SignUpBtnLoc).click();
	}

//Entering Email Id
	public void enterEmailId(String mailid) {
		driver.findElement(enterEmailLoc).sendKeys(mailid);
	}

//Reentering Email Id
	public void reEnterEmailId( String mailid) {
		driver.findElement(reEnterEmailLoc).sendKeys(mailid);
	}

//Entering Password
	public void enterPassword( String password) {
		driver.findElement(enterPasswordLoc).sendKeys(password);
	}

//Re entering Password
	public void reEnterPassword( String password) {
		driver.findElement(reEnterPasswordLoc).sendKeys(password);
	}

	// Clicking on SignUpNow button
	public void ClickOnSignUpNow() {
		driver.findElement(SignUpNowBtnLoc).click();
	}

//Waiting For signinMessage to display
	public void signinMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(SignUpmsgLoc));
	}

//Waiting For invalid credentials Message to display
	public void invalidMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(invalidmsgLoc));
	}

//Entering Email Id
	public void enteringLoginEmail(String email) {
		driver.findElement(loginEmailLoc).sendKeys(email);
	}

//Entering Password
	public void enteringLoginPassword( String password) {
		driver.findElement(loginPasswordLoc).sendKeys(password);
	}

//Clicking On Login
	public void clickingValidLogin() {
		driver.findElement(loginLoc).click();
	}

//Reading actual text when invalid mailid is provided
	public String gettingInValidMailText() {
		String actualText = driver.findElement(invalidMailTextLoc).getText();
		return actualText;
	}

//Reading actual text when invalid Password is provided
	public String gettingInValidPasswordText() {
		String actualText = driver.findElement(invalidMailTextLoc).getText();
		return actualText;
	}

}