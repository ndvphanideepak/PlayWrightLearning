package week1;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HomeWork {

	@Test
	public void testHomeWork() throws InterruptedException
	{
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login-leaftaps.json")));
		Page newPage = newContext.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		newPage.click("text=CRM/SFA");
		newPage.click("text=Leads");
		newPage.click("//a[text()='Find Leads']");
		newPage.click("//span[text()='Phone']");
		newPage.locator("//input[@name='phoneCountryCode']").clear();
		newPage.locator("//input[@name='phoneCountryCode']").type("1");
		newPage.click("//button[text()='Find Leads']");
		Thread.sleep(4000);
		String textlead = newPage.locator("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]").textContent();
		System.out.println(textlead);
		newPage.click("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[1]");
		newPage.click("//a[text()='Delete']");
		Thread.sleep(4000);
		newPage.click("//a[text()='Find Leads']");
		newPage.type("//input[@name='id']", textlead);
		newPage.click("//button[text()='Find Leads']");
		
	}

}
