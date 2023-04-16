package week2;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class DropDownsTest {
	@Test
	public void dropDowns() throws InterruptedException
	{
		Playwright create = Playwright.create();
		Browser launch = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page newPage = launch.newPage();
		newPage.navigate("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		newPage.locator("//select[@id='first']").selectOption(new SelectOption().setIndex(3));
		Thread.sleep(5000);
		
		
		
	}

}
