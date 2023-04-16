package week2.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class BrowserContext2apps {
	@Test
	public void twoAppsSwitch() throws InterruptedException
	{
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext1 = browser.newContext();
		Page newPage1 = newContext1.newPage();
		BrowserContext newContext2 = browser.newContext();
		Page newPage2 = newContext2.newPage();
		newPage1.navigate("http://leaftaps.com/opentaps");
		newPage2.navigate("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Locator locator = newPage1.locator("//input[@id='username']");
		locator.type("demosalesmanager");
		newPage1.locator("//input[@id='password']").type("crmsfa");
		newPage1.locator("//input[@value='Login']").click();
		newPage2.locator("//select[@id='first']").selectOption(new SelectOption().setIndex(3));
		Thread.sleep(5000);
	}

}
