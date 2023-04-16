package week1;

import org.testng.annotations.Test;

import com.microsoft.playwright.APIRequest.NewContextOptions;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class HandlewindowAuth {
	@Test
	public void windowAuth() throws InterruptedException {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = browser
				.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
		Page newPage = newContext.newPage();
		newPage.navigate("https://the-internet.herokuapp.com/");
		newPage.click("//a[normalize-space()='Basic Auth']");
		Thread.sleep(10000);
		newPage.close();
		browser.close();
		pw.close();

	}

}
