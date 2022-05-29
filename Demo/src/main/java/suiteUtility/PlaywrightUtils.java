package suiteUtility;

import com.microsoft.playwright.Page;

public class PlaywrightUtils {
	
	public void click(Page page, WebPageElements ele) {
		page.locator(ele.getValue()).click();
	}
	
	public void setText(Page page, WebPageElements ele, String text) {
		page.locator(ele.getValue()).type(text);
	}
	
	public void selectOption(Page page, WebPageElements ele, String text) {
		page.locator(ele.getValue()).selectOption(text);
	}

}
