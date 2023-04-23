package week3;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class TraceTC {
//mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
	//https://trace.playwright.dev/
	public static void main(String[] args) {
		Playwright playWright = Playwright.create();
		Browser launch = playWright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = launch.newContext();
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
				
		Page newPage = context.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		Locator locator = newPage.locator("//input[@id='username']");
		locator.type("demosalesmanager");
		newPage.locator("//input[@id='password']").type("crmsfa");
		newPage.locator("//input[@value='Login']").click();
		newPage.click("text=CRM/SFA");
		newPage.goBack();
		newPage.goForward();
		System.out.println(newPage.url());
		newPage.reload();

		newPage.click("text=Leads");
		newPage.click("text=Create Lead");
		newPage.type("//input[@id='createLeadForm_companyName']", "Demo");
		// String textContent = newPage.locator("//*[@id='ext-gen638']").textContent();
		// System.out.println(textContent);
		newPage.type("#createLeadForm_firstName", "Demo First");
		newPage.type("#createLeadForm_lastName", "Demo Surname ");
		newPage.click(".smallSubmit");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		newPage.close();
		launch.close();
		playWright.close();

	}

}
