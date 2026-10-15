package utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest extends ListenrsLogic
{
	
	@Parameters("engine")
	@BeforeMethod
	public void launch(String nameofSearchEngine)
	{
		if(nameofSearchEngine.equals("chrome"))
		{
		playwright =     Playwright.create();
		browser =        playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=            browser.newPage();
		}
		if(nameofSearchEngine.equals("webkit"))
		{
		playwright =     Playwright.create();
		browser =        playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=            browser.newPage();
		}
		if(nameofSearchEngine.equals("firefox"))
		{
		playwright =     Playwright.create();
		browser =        playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page=            browser.newPage();
		}
		page.navigate("https://www.amazon.in");
		
	}
	
	
	@AfterMethod
	
	public void quit()
	{
		browser.close();
	}	
}
