package week1;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoLogin {
@Test
	public  void run() {
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("login-leaftaps.json")));
		Page newPage = newContext.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		newPage.click("text=CRM/SFA");
		newPage.click("text=Leads");
		newPage.click("text=Create Lead");
		newPage.type("//input[@id='createLeadForm_companyName']", "Demo");
		newPage.type("#createLeadForm_firstName", "Demo First");
		newPage.type("#createLeadForm_lastName", "Demo Surname ");
		newPage.click(".smallSubmit");
		newPage.close();
		browser.close();
		pw.close();

	}

}
