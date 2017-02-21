package com.sqa.gy;

import static org.testng.Assert.*;

import java.text.*;
import java.util.*;
import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import com.sqa.gy.adactin.*;

public class AdactinTestCases {

	private boolean acceptNextAlert = true;

	private String baseUrl;
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@DataProvider
	public Object[][] dptc101login() {
		return new Object[][] { new Object[] { "galinasusername", "PASSWORD" },
				new Object[] { "galinasusername", "password" }, new Object[] { "notmyusername", "PASSWORD" },
				new Object[] { "", "PASSWORD" }, new Object[] { "galinasusername", "" }, };
	}

	@DataProvider
	public Object[][] dptc102checkoutdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Calendar calPlus7 = Calendar.getInstance();
		calPlus7.add(Calendar.DAY_OF_MONTH, 7);
		Date todayPlusSeven = calPlus7.getTime();
		String todayPlus7 = sdf.format(todayPlusSeven);

		Calendar calPlus2 = Calendar.getInstance();
		calPlus2.add(Calendar.DAY_OF_MONTH, 2);
		Date todayPlusTwo = calPlus2.getTime();
		String todayPlus2 = sdf.format(todayPlusTwo);

		return new Object[][] { new Object[] { "galinasusername", "PASSWORD", "Sydney", "Hotel Creek", "standard",
				todayPlus7, todayPlus2, "null", "null" } };
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://adactin.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test(dataProvider = "dptc101login")
	public void testLoginAdactinHotelApp(String usrnm, String passwd) throws Exception {
		LoginPage loginTest = new LoginPage(this.driver);
		loginTest.loginSteps(usrnm, passwd);
		// this.driver.get(this.baseUrl + "/HotelAppBuild2/index.php");
		// this.driver.findElement(By.id("username")).clear();
		// this.driver.findElement(By.id("username")).sendKeys(usrnm);
		// this.driver.findElement(By.id("password")).clear();
		// this.driver.findElement(By.id("password")).sendKeys(passwd);
		// this.driver.findElement(By.id("login")).click();
		assertEquals(this.driver.findElement(By.id("username_show")).getAttribute("value"), "Hello " + usrnm + "!");
	}

	@Test(dataProvider = "dptc102checkoutdate")
	public void testTc102(String usrnm, String passwd, String city, String hotel, String roomtype, String chkin,
			String chkout) throws Exception {
		this.driver.get(this.baseUrl + "/HotelAppBuild2/");
		this.driver.findElement(By.id("username")).clear();
		this.driver.findElement(By.id("username")).sendKeys(usrnm);
		this.driver.findElement(By.id("password")).clear();
		this.driver.findElement(By.id("password")).sendKeys(passwd);
		this.driver.findElement(By.id("login")).click();
		Select select1 = new Select(this.driver.findElement(By.id("location")));
		select1.selectByVisibleText(city);
		Select select2 = new Select(this.driver.findElement(By.id("hotels")));
		select2.selectByVisibleText(hotel);
		Select select3 = new Select(this.driver.findElement(By.id("room_type")));
		select3.selectByVisibleText(roomtype);
		this.driver.findElement(By.id("datepick_in")).clear();
		this.driver.findElement(By.id("datepick_in")).sendKeys(chkin);
		this.driver.findElement(By.id("datepick_out")).clear();
		this.driver.findElement(By.id("datepick_out")).sendKeys(chkout);
		this.driver.findElement(By.id("Submit")).click();
		this.isElementPresent(By.className("reg_error"));
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
