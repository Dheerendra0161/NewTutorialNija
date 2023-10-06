package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingWarning;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordMatchingWarning;
	
	@FindBy(xpath = "//div[*/div]")
	private WebElement emailAndPassword;
	
	@FindBy(xpath = "//div")
	private WebElement emaildddddddddddddddd;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // can use object :new LoginPage(driver) or LoginPage.this: instead of :this:
	}

	public AccountPage login(String emailText, String passwordText) {

		emailAddressField.sendKeys(emailText);
		passwordField.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);

	}

	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);

	}

	public String retrieveEmailPasswordNotMatchingWarningMessageText() {
		String warningText = emailPasswordNotMatchingWarning.getText();
		return warningText;

	}

}
