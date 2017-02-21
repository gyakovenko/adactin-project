package com.sqa.gy.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.gy.adactin.helpers.*;

public class SearchHotelPage {

	@FindBy(id = "datepick_in")
	private WebElement checkInDate;

	@FindBy(id = "datepick_out")
	private WebElement checkOutDate;

	private WebDriver driver;

	@FindBy(id = "hotels")
	private WebElement hotelSelect;

	@FindBy(id = "location")
	private WebElement locationSelect;

	@FindBy(id = "adult_room")
	private WebElement noAdultsInRoomSelect;

	@FindBy(id = "child_room")
	private WebElement noChildrenInRoomSelect;

	@FindBy(id = "Reset")
	private WebElement resetButton;

	@FindBy(id = "room_type")
	private WebElement roomTypeSelect;

	@FindBy(id = "Submit")
	private WebElement searchButton;

	public SearchHotelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void chooseHotel(String hotelName) {
		Select selectFromHotels = new Select(this.hotelSelect);
		selectFromHotels.selectByVisibleText(hotelName);
	}

	public void searchForHotel(String city, String hotel, String roomType, String checkInDate, String checkOutDate,
			String numOfAdultsInRoom, String numOfChildrenInRoom) {
		HelperMethods.selectFromDropDown(city, this.locationSelect);
		HelperMethods.selectFromDropDown(hotel, this.hotelSelect);
		HelperMethods.selectFromDropDown(roomType, this.roomTypeSelect);
		HelperMethods.clearAndSendKeysToField(checkInDate, this.checkInDate);
		HelperMethods.clearAndSendKeysToField(checkOutDate, this.checkOutDate);
		HelperMethods.selectFromDropDown(numOfAdultsInRoom, this.noAdultsInRoomSelect);
		HelperMethods.selectFromDropDown(numOfChildrenInRoom, this.noChildrenInRoomSelect);
		this.searchButton.click();
	}

	// this will go in the page that calls this page obejct and does the test
	// this.isElementPresent(By.className("reg_error"));

}
