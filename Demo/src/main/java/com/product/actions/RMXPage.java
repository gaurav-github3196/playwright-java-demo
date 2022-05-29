package com.product.actions;

import com.microsoft.playwright.Page;
import com.product.objects.IRMXPage;

import suiteUtility.PlaywrightUtils;

public class RMXPage extends PlaywrightUtils implements  IRMXPage{

	public void gotoFilterManager(Page page) {
		click(page, MORE_OPTIONS);
		click(page, FILTER_MANAGER);
	}
	
	
}
