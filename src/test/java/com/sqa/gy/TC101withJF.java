package com.sqa.gy;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.gy.adactin.*;

public class TC101withJF {

	private static String baseUrl = "http://adactin.com/HotelAppBuild2";
	private static String pass = "PASSWORD";
	private static String user = "galinasusername";
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// create webdriver instance here where its available to all methods:
		this.driver = new FirefoxDriver();
		// Move the driver to the base URL
		this.driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() {
		// Quit current instance of driver, for only current window
		this.driver.quit();
	}

	@Test
	public void testHotelSearch() {
		new LoginPage(this.driver).loginSteps(user, pass).chooseHotel("Hotel Creek");
	}

	@Test
	public void testLogin() throws InterruptedException {
		System.out.println("Test");
		String expected = "AdactIn.com - Search Hotel";
		Thread.sleep(5000);
		LoginPage loginPage = new LoginPage(this.driver);
		loginPage.loginSteps(user, pass);
		Assert.assertEquals(this.driver.getTitle(), expected, "Did not arrive on the correct page.");

	}

	// private void loginToAdaction() {
	// // Create WebElements. this makes it easier to work w the elements, esp
	// // if we id them not by super easy id or class, but something more
	// // annoying
	// WebElement usernameField = this.driver.findElement(By.id("username"));
	// WebElement passwordField = this.driver.findElement(By.id("password"));
	// WebElement loginButton = this.driver.findElement(By.id("login"));
	// usernameField.clear();
	// usernameField.sendKeys(user);
	// passwordField.clear();
	// passwordField.sendKeys(pass);
	// loginButton.click();
	// // ^other option: IF its a form, you can do anyField.submit() instead of
	// // button.click()
	// }

}