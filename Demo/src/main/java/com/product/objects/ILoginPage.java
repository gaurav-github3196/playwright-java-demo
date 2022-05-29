package com.product.objects;

import suiteUtility.WebPageElements;

public interface ILoginPage {

	String userid = "//input[@id='txtUserId']";
	WebPageElements USERID = new WebPageElements("User ID Field", "xpath", userid);
	
	String password_field = "//input[@id='txtPassword']";
	WebPageElements PASSWORD_FIELD = new WebPageElements("Password Field", "xpath", password_field);
	
	String login_button = "//input[@id='btnLogin']";
	WebPageElements LOGIN_BUTTON = new WebPageElements("Login Button", "xpath", login_button);
	
}
