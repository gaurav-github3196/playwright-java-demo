package com.product.actions;

import com.microsoft.playwright.Page;
import com.product.objects.IHomePage;

import suiteUtility.PlaywrightUtils;

public class HomePage extends PlaywrightUtils implements IHomePage{
	 
	public void gotoAccountSettingsPage(Page page) {
		click(page, ACCOUNT_SETTING_DROPDOWN);
		click(page, ACCOUNT_SETTING);
	}
	
	public void gotoOmniReport(Page page, int SID) {
		page.navigate("https://www.sogosurvey.com/zRMX/OmniReport.aspx?&sid=" + SID +"&DNA=False&QuickAccess=true");
		
	}
	
	
}
