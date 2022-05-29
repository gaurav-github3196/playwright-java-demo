package com.product.objects;

import suiteUtility.WebPageElements;

public interface IOmniPage {

	String save_report_button = "//a[@id='btnPageSave']";
	WebPageElements SAVE_REPORT_BUTTON = new WebPageElements("Save Report Button", "xpath", save_report_button);
	
	String save_report_textbox = "//input[@id='txtReportName']";
	WebPageElements SAVE_REPORT_TEXTBOX = new WebPageElements("Save Report TextBox", "xpath", save_report_textbox);
	
	String save_button = "//input[@id='imgsave']";
	WebPageElements SAVE_BUTTON = new WebPageElements("Save Button", "xpath", save_button);
	
	String email_report = "//a[@id='hrefShare']";
	WebPageElements EMAIL_REPORT = new WebPageElements("Email report", "xpath", email_report);
	
	String report_title = "//input[@id='TxtReportName']";
	WebPageElements REPORT_TITLE = new WebPageElements("Report Title", "xpath", report_title);
	
	String to_email = "//input[@id='TextToEmail']";
	WebPageElements TO_EMAIL = new WebPageElements("To Field", "xpath", to_email);
	
	String continue_button = "//input[@id='StepNext']";
	WebPageElements CONTINUE_BUTTON = new WebPageElements("Continue", "xpath", continue_button);
	
	String send_report = "//input[@id='btnSubmit']";
	WebPageElements SEND_REPORT = new WebPageElements("Send Report", "xpath", send_report);
	
	
}
