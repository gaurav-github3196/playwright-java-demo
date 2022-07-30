package com.product.tests;

import java.nio.file.Paths;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Tracing;

import suitebase.SuiteBase;

public class LoginTC extends SuiteBase{
	
	@BeforeMethod
	public void beforeMethod() {
		context.tracing().startChunk();	
	}
	
	@Test
	public void testCase1() {
		loginPage.loginToPlatform(page);
		homePage.gotoOmniReport(page, 342);
		omniPage.saveOmniReport(page);
		omniPage.emailOmniReport(page);
	}
	
	
	@Test
	public void testCase2() {
		loginPage.loginToPlatform(page);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if(Boolean.parseBoolean(prop.getProperty("traceviewer"))) {
			context.tracing().stopChunk(new Tracing.StopChunkOptions().setPath(Paths.get(System.getProperty("user.dir") + "//traceviewer//" + result.getMethod().getMethodName() +".zip")));
		}
	}

}
