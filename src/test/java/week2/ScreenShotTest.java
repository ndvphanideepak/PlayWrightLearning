package week2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenShotTest {
	@Test
	public void Login() {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = browser.newContext();
		Page newPage = newContext.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		newPage.screenshot(new Page.ScreenshotOptions()
			      .setPath(Paths.get("snaps/screenshot.png")));
		
		
		
	}
}
