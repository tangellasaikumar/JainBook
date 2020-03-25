package com.cts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	private static By LoginBtnLoc = By.xpath("//a[@id='login']");
	private static By SignUpBtnLoc = By.xpath("//input[@id='btnsubmit0']");
	private static By enterEmailLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox4']");
	private static By reEnterEmailLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox8']");
	private static By enterPasswordLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox6']");
	private static By reEnterPasswordLoc = By.xpath("//input[@id='ContentPlaceHolder1_TextBox7']");
	private static By SignUpNowBtnLoc = By.xpath("//input[@id='ContentPlaceHolder1_btnsubmit']");
	private static By SignUpmsgLoc = By.xpath("//div[contains(text(),'Unable To Login')]");
	private static By invalidmsgLoc = By
			.xpath("//div[contains(text(),'Please Check The Email: Both The Email Do Not Match.')]");
	private static By loginEmailLoc = By.xpath("(//input[@id='ContentPlaceHolder1_TextBox1'])[1]");
	private static By loginPasswordLoc = By.xpath("(//input[@id='ContentPlaceHolder1_TextBox2'])[1]");
	private static By loginLoc = By.xpath("(//input[@id='ContentPlaceHolder1_btnlogin'])[1]");
	private static By invalidMailTextLoc = By.xpath("(//div[@class='modal-body'])[3]");

	
	//Clicking On Login on the home page
	public static void ClickOnLogin(WebDriver driver) {
		driver.findElement(LoginBtnLoc).click();
	}

	//Clicking On SignUp Button
	public static void ClickOnSignUp(WebDriver driver) {
		driver.findElement(SignUpBtnLoc).click();
	}

	//Entering Email Id 
	public static void enterEmailId(WebDriver driver, String mailid) {
		driver.findElement(enterEmailLoc).sendKeys(mailid);
	}

	//Reentering Email Id
	public static void reEnterEmailId(WebDriver driver, String mailid) {
		driver.findElement(reEnterEmailLoc).sendKeys(mailid);
	}

	//Entering Password
	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(enterPasswordLoc).sendKeys(password);
	}

	//Re entering Password
	public static void reEnterPassword(WebDriver driver, String password) {
		driver.findElement(reEnterPasswordLoc).sendKeys(password);
	}
	
    //Clicking on SignUpNow button
	public static void ClickOnSignUpNow(WebDriver driver) {
		driver.findElement(SignUpNowBtnLoc).click();
	}

	//Waiting For signinMessage to display
	public static void signinMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(SignUpmsgLoc));
	}

	//Waiting For invalid credentials Message to display
	public static void invalidMessage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(invalidmsgLoc));
	}

	//Entering Email Id
	public static void enteringLoginEmail(WebDriver driver, String email) {
		driver.findElement(loginEmailLoc).sendKeys(email);
	}

	//Entering Password
	public static void enteringLoginPassword(WebDriver driver, String password) {
		driver.findElement(loginPasswordLoc).sendKeys(password);
	}

	//Clicking On Login
	public static void clickingValidLogin(WebDriver driver) {
		driver.findElement(loginLoc).click();
	}

	//Reading actual text when invalid mailid is provided 
	public static String gettingInValidMailText(WebDriver driver) {
		String actualText = driver.findElement(invalidMailTextLoc).getText();
		return actualText;
	}

	//Reading actual text when invalid Password is provided 
	public static String gettingInValidPasswordText(WebDriver driver) {
		String actualText = driver.findElement(invalidMailTextLoc).getText();
		return actualText;
	}

}
