package com.product.actions;

import java.sql.Timestamp;

import com.microsoft.playwright.Page;
import com.product.objects.IOmniPage;

import suiteUtility.PlaywrightUtils;

public class OmniPage extends PlaywrightUtils implements IOmniPage{
	
	public void saveOmniReport(Page page) {
		click(page, SAVE_REPORT_BUTTON);
		setText(page, SAVE_REPORT_TEXTBOX, "Omni Report "+ getCurrentTimestamp().toString());
		click(page, SAVE_BUTTON);
	}
	
	public void emailOmniReport(Page page) {
		click(page, EMAIL_REPORT);
		setText(page, REPORT_TITLE, "Omni Report - " + getCurrentTimestamp().toString());
		setText(page, TO_EMAIL, "ggolatkar@zarca.com");
		click(page, CONTINUE_BUTTON);
		click(page, SEND_REPORT);
	}
	
	public Timestamp getCurrentTimestamp() {
		return  new Timestamp(System.currentTimeMillis());
	}

}
