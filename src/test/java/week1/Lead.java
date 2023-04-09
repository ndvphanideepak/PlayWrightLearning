package week1;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class Lead {
	@Test
	public void createLead()
	{
		Playwright playWright= Playwright.create();
		Browser launch = playWright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page newPage = launch.newPage();
		newPage.navigate("http://leaftaps.com/opentaps");
		
		  Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		  int width = (int)screenSize.getWidth(); 
		  int height =(int)screenSize.getHeight();
		 
		/*
		 * GraphicsDevice defaultScreenDevice =
		 * GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		 * int width = defaultScreenDevice.getDisplayMode().getWidth(); int height =
		 * defaultScreenDevice.getDisplayMode().getHeight();
		 */
		newPage.setViewportSize(width, height);
		
		
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
		//String textContent = newPage.locator("//*[@id='ext-gen638']").textContent();
		//System.out.println(textContent);
		newPage.type("#createLeadForm_firstName", "Demo First");
		newPage.type("#createLeadForm_lastName", "Demo Surname ");
		newPage.click(".smallSubmit");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newPage.close();
		launch.close();
		playWright.close();
	}

}
