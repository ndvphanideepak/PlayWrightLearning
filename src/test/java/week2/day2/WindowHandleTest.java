package week2.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowHandleTest {
	@Test
	public void windowhandleTest() throws InterruptedException
	{
		Playwright create = Playwright.create();
		Browser launch = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext newContext = launch.newContext();
	Page newPage = newContext.newPage();
	newPage.navigate("https://leafground.com/window.xhtml");
	newPage.click("//span[normalize-space()='Open']");
	Page childPage = newContext.waitForPage(()->{
		newPage.locator("//input[@id='email']").isVisible();
	});
	childPage.type("//input[@id='email']", "deepak@test.com");
	Thread.sleep(5000);
	
	}

}
