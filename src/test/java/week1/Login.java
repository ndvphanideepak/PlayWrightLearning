package week1;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Login {
	@Test
	public void Login()
	{
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = browser.newContext();
		Page newPage = newContext.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		Locator locator = newPage.locator("//input[@id='username']");
		locator.type("demosalesmanager");
		newPage.locator("//input[@id='password']").type("crmsfa");
		newPage.locator("//input[@value='Login']").click();
		newContext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("login-leaftaps.json")));
	}

}
