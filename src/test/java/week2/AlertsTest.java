package week2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AlertsTest {
	@Test
	public void alerTest() throws InterruptedException
	{
		Playwright create = Playwright.create();
		Browser launch = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	Page newPage = launch.newPage();
	newPage.navigate("https://leafground.com/alert.xhtml");
	newPage.locator("//h5[normalize-space()='Alert (Simple Dialog)']//following::button[1]").click();
	Thread.sleep(5000);
	
	}

}
