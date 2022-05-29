package com.product.objects;

import suiteUtility.WebPageElements;

public interface IRMXPage {
	
	String more_options = "//div[@title='More']";
	WebPageElements MORE_OPTIONS = new WebPageElements("More (Three Dot Options)", "xpath", more_options);	
	
	String filter_manager = "//span[normalize-space()='Filter Manager']";
	WebPageElements FILTER_MANAGER = new WebPageElements("Filter Manager", "xpath", filter_manager);
	
	String create_new = "//input[@id='btnNew']";
	WebPageElements CREATE_NEW = new WebPageElements("Create New Filter", "xpath", create_new);
	

}