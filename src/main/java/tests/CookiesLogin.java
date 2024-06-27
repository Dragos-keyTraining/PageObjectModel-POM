package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import page.objects.LoginPage;
import page.objects.MenuPage;
import selenium.utils.BaseTest;

public class CookiesLogin extends BaseTest {

	Set<Cookie> cookies;

	String USER = PropertiesFileProcessor.readPropertiesFile("user", "credentials.properties");
	String PASS = PropertiesFileProcessor.readPropertiesFile("pass", "credentials.properties");

	
	@Test(priority = 1)
	public void validLoginTest() {
		
		MenuPage menuPage = new MenuPage(driver);		
		menuPage.click(menuPage.loginLink);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginInApp(USER, PASS);
		assertTrue(loginPage.checkMsgIsDisplayed(loginPage.successLoginMsg));
		
		cookies = driver.manage().getCookies();
		System.out.println(cookies);
		
	}
	
	@Test(priority = 2)
	public void cookiesLogin() throws InterruptedException {
		
		MenuPage menuPage = new MenuPage(driver);		
		menuPage.click(menuPage.loginLink);
		
		for(Cookie cook : cookies) {
		
			driver.manage().addCookie(cook);
		}
		
		//Thread.sleep(3000);
		menuPage.click(menuPage.contactsLink);

		
	}
	
	
}
