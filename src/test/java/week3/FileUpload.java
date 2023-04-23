package week3;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUpload {

		@Test
		public void fileUpload1() throws InterruptedException
		{
			Playwright create = Playwright.create();
			Browser launch = create.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext newContext = launch.newContext();
		Page newPage = newContext.newPage();
		newPage.navigate("https://leafground.com/file.xhtml");
		newPage.locator("//input[@id='j_idt88:j_idt89_input']").setInputFiles(Paths.get("login-leaftaps.json"));
		}
	
}
