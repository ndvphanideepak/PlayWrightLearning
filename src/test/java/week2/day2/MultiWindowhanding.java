package week2.day2;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultiWindowhanding {
	
	@Test
	public void multipleWindowhandleTest() throws InterruptedException
	{
		Playwright create = Playwright.create();
		Browser browser = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
	Page page = context.newPage();
	page.navigate("https://leafground.com/window.xhtml");
	page.click("//h5[text()='Find the number of opened tabs']/following::span[1]");
	List<Page> pages = page.context().pages();
	Page WebTablePage = null;
	for(Page window:pages)
	{
		if(window.title().equals("Web Table"))
		{
			WebTablePage=window;
		}
		
	}
	WebTablePage.type("//input[@placeholder='Search']", "Test");
	Thread.sleep(5000);
	
	}

}
