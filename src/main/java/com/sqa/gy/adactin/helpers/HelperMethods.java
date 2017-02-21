
package com.sqa.gy.adactin.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HelperMethods {

	public static void clearAndSendKeysToField(String value, WebElement element) {
		element.clear();
		element.sendKeys(value);
	}

	public static void selectFromDropDown(String value, WebElement element) {
		if (!value.equalsIgnoreCase("null")) {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		}
	}
}
