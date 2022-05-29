package com.product.tests;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Tracing;

import suitebase.SuiteBase;

public class LoginTC extends SuiteBase{
	
	
	@Test
	public void testCase1() {
		loginPage.loginToPlatform(page);
		homePage.gotoOmniReport(page, 342);
		omniPage.saveOmniReport(page);
		omniPage.emailOmniReport(page);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		if(Boolean.parseBoolean(prop.getProperty("traceviewer"))) {
			System.out.println("------------ Tracing stopped --------------");
			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(System.getProperty("user.dir") + "//traceviewer//trace.zip")));
		}
	}

}
