package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchDetailsPage {
	
	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//h1[text()= 'HP LP3065']")
	private WebElement productName;
	
	@FindBy(xpath="//h2[text()= '$122.00']")
	private WebElement productPrice;

	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//div[text()='Success: You have added ']")
	private WebElement addToCartSuccess;
	
	
	public SearchDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void validateProductDetails() {
		Assert.assertTrue(productName.getText().equals(SearchPage.prodName),"Not Matched");
		Assert.assertTrue(SearchPage.prodPrice.contains(productPrice.getText()), "Not Matched");
	}

	public void addToCart() {
		addToCart.click();
		Assert.assertTrue(addToCartSuccess.isDisplayed(), "Not added");
		//return shippingCart;
	}
}
