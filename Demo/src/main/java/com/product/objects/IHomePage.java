package com.product.objects;

import suiteUtility.WebPageElements;

public interface IHomePage {

	String account_setting_dropdown = "//span[@id='z_h_ctl00_lblInitials1']";
	WebPageElements ACCOUNT_SETTING_DROPDOWN = new WebPageElements("Account Setting Dropdown", "xpath", account_setting_dropdown);
	
	String account_setting = "//div[@id='z_h_ctl00_liAccountSettings']";
	WebPageElements ACCOUNT_SETTING = new WebPageElements("Account Setting", "xpath", account_setting);
	
	
}
