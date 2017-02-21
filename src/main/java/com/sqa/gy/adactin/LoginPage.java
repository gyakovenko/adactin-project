package com.sqa.gy.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

	private WebDriver driver;

	@FindBy(id = "login")
	private WebElement loginButton;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "username") // or @FindBy(how = How.ID, using= "username")
								// recommended if you're using templates where
								// you're auto filling in
	private WebElement usernameField;

	// constructor for LoginPage Class. instance will be created by test and
	// will
	// pass in the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SearchHotelPage loginSteps(String username, String password) {
		// WebElements set up with the @FindBy
		this.usernameField.clear();
		this.usernameField.sendKeys(username);
		this.passwordField.clear();
		this.passwordField.sendKeys(password);
		this.loginButton.click();
		return new SearchHotelPage(this.driver);
	}
}
