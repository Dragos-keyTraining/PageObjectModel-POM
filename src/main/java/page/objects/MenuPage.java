package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers{

	public WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//@FindBy
	
	//driver.findElement(By.linkText('Login'));
	public By loginLink = By.linkText("Login");
	public By shopLink = By.linkText("BOOKS");
	public By contactsLink = By.linkText("CONTACTS");
	public By blogLink = By.linkText("BLOG");
	public By aboutLink = By.linkText("ABOUT");
	
	public By iconSearch = By.cssSelector("div[class='top_panel_middle'] button[class*='icon-search']");
	public By searchField = By.cssSelector("div[class='top_panel_middle'] input");
	
/*	public void navigateTo(By locator) {
		driver.findElement(locator).click();
	}*/
	
	public void search( String searchValue) {
		
		click(iconSearch);
		sendKeys(searchField, searchValue);
		click(iconSearch);
	}
	
	
}
