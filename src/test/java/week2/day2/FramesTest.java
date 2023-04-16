package week2.day2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FramesTest {
	@Test
	public void frameTest() throws InterruptedException
	{
		Playwright create = Playwright.create();
		Browser launch = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page newPage = launch.newPage();
		newPage.navigate("https://leafground.com/frame.xhtml");
		FrameLocator frameLocator1 = newPage.frameLocator("//iframe[@src='default.xhtml']");
		frameLocator1.locator("//button[@id='Click']").click();
		Thread.sleep(5000);
		FrameLocator frameLocator2 = newPage.frameLocator("//iframe[@src='page.xhtml']");
		FrameLocator frameLocator3 = frameLocator2.frameLocator("//iframe[@id='frame2']");
		frameLocator3.locator("//button[@id='Click']").click();
		Thread.sleep(5000);
	}

}
