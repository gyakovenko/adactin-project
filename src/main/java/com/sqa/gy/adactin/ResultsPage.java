/**
 *   File Name: ResultsPage.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Feb 2, 2017
 *
 */

package com.sqa.gy.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

/**
 * ResultsPage
 */
public class ResultsPage {

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

	// public SearchHotelPage(WebDriver driver) {
	// this.driver = driver;
	// PageFactory.initElements(driver, this);
	// }

	// public void chooseHotel(String hotelName) {
	// Select selectFromHotels = new Select(this.hotelSelect);
	// selectFromHotels.selectByVisibleText(hotelName);
	// }

	// public void searchForHotel(String city, String hotel, String roomType,
	// String checkInDate, String checkOutDate,
	// String numOfAdultsInRoom, String numOfChildrenInRoom) {
	//
	// }
}
