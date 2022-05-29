package com.product.actions;

import com.microsoft.playwright.Page;
import com.product.objects.ILoginPage;

import suiteUtility.PlaywrightUtils;

public class LoginPage extends PlaywrightUtils implements ILoginPage{

	public void loginToPlatform(Page page) {
		page.navigate("https://www.sogosurvey.com/static/login.aspx");
		setText(page, USERID, "sogo_gauravg");
		setText(page, PASSWORD_FIELD, "GVG3196@test");
		click(page, LOGIN_BUTTON);
	}
	
}
