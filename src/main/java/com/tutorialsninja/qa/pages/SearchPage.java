package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;

	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMessage;
	
	@FindBy(xpath = "//p[@class='price']")
	private WebElement productPr;

	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String retrieveNoProductMessageText() {
		String noProductMessageText = noProductMessage.getText();
		return noProductMessageText;
	}

	public boolean displayStatusOfHPValidProduct() {
		boolean displayStatus = validHPProduct.isDisplayed();
		return displayStatus;
	}

	
	
	public static String prodName;
	public static String prodPrice;
	
	public SearchDetailsPage navigateFirstProduct() {
		prodName=validHPProduct.getText();
		prodPrice= productPr.getText();
		validHPProduct.click();
		return new SearchDetailsPage(driver);
	}
}
