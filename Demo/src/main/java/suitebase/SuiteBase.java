package suitebase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.w3c.dom.Document;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.Proxy;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.product.actions.HomePage;
import com.product.actions.LoginPage;
import com.product.actions.OmniPage;

public class SuiteBase {
	
	public Playwright playwright;
	public Browser browser;
	public Page page;
	public BrowserContext context;
	public FileReader reader = null;
	public Properties prop = null;
	public Document configReader;
	public LoginPage loginPage = new LoginPage();
	public HomePage homePage = new HomePage();
	public OmniPage omniPage = new OmniPage();
	
	private static final String ZAP_API_KEY = "ac47ct5pu4v60h7ujl02nct8ne";
	private static final String ZAP_PROXY_ADDRESS = "localhost";
	private static final int ZAP_PROXY_PORT = 8080;
	
	private ClientApi clientApi = null;
	
	

	@BeforeSuite
	public void setup() {
		try {
			reader=new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\suiteProperties.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		playwright = Playwright.create();
		LaunchOptions options = new BrowserType.LaunchOptions();
		options.setHeadless(false);
		options.setChannel("chrome");
		options.setArgs(Arrays.asList("--start-maximized"));
		
		
		if(Boolean.parseBoolean(prop.getProperty("setProxy"))) {
			options.setProxy(setUpProxy());
		}
		
		browser = playwright.chromium().launch(options);

		
		NewContextOptions contextOptions = new NewContextOptions()
				.setJavaScriptEnabled(true)
				.setIgnoreHTTPSErrors(true)
				.setViewportSize(null);
		
		context = browser.newContext(contextOptions);
		
		if(Boolean.parseBoolean(prop.getProperty("traceviewer"))) {
			context.tracing().start(new Tracing.StartOptions()
					.setScreenshots(true)
					.setSnapshots(true));
		}
		page = context.newPage();
		
		if(Boolean.parseBoolean(prop.getProperty("setProxy"))) {
			clientApi = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);
		}
	}
	
	public Proxy setUpProxy() {
		String proxyServerUrl = ZAP_PROXY_ADDRESS + ":" +ZAP_PROXY_PORT;
		Proxy proxy = new Proxy(proxyServerUrl);
		return proxy;
	}
	
	
	
	@AfterSuite
	public void tearDown() {		
		
		if(clientApi != null) {
			String title = "Zap Security Report";
			String template = "traditional-html";
			String description = "This is SoGoSurvey Security Test Report";
			String reportfilename = "sogo-zap-report.html";
			String targetFolder = System.getProperty("user.dir") + "//zap-reports//";

			
			try {
				ApiResponse response = clientApi.reports.generate(title, template, null, description, null, null, null, null, null,
						reportfilename, null, targetFolder, null );
			} catch (ClientApiException e) {
				e.printStackTrace();
			}
		}
		
		page.close();
		context.close();
	}
	
	
}
