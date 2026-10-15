package amazontest.AmzProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import utility.BaseTest;
import utility.ListenrsLogic;
import utility.RetryLogic;
@Listeners(ListenrsLogic.class)
public class TestCase1_LoginToAmazon extends BaseTest
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void withValidCredentails() throws InterruptedException
	{
		HomePage homepage=new HomePage(page);
		
		homepage.hoverOverOnAccountAndList();
		homepage.clickOnSigin();
//		page.wait(3000);
		
		LoginPage loginpage=new LoginPage(page);
		
		loginpage.enterUsername("rohini.s.date94@gmail.com");
		loginpage.clickOnContinue();
																																																			loginpage.enterpassword("123456");
		loginpage.clickOnSigin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Locator searchText= page.getByLabel("Search Amazon.in");
		assertThat(searchText).isVisible();
	}
}
