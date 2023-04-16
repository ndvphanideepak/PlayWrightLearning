package week2;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Video;

public class VideoContext {

	@Test
	public void videoContext()
	{
		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		
		BrowserContext context = browser.newContext();
		context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		Page newPage = context.newPage();
		Video video = newPage.video();
		newPage.navigate("https://playwright.dev/java/docs/videos");
		
		// Make sure to close, so that videos are saved.
		context.close();
		newPage.close();
		video.saveAs(Paths.get("videos/devpages"+System.currentTimeMillis()+".webm"));
		browser.close();
	}
}
