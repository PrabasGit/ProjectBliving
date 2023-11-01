package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(linkText = "Sign in")
	public static WebElement signin;

	@FindBy(xpath = "//input[@type='search']")
	public static WebElement searchBox;

	@FindBy(xpath = "(//a[@role='menuitem'])[2]//child::span")
	public static WebElement brandDropdown;

	@FindBy(xpath = "(//a[@role='menuitem'])[6]//child::span")
	public static WebElement shopDropdown;
	
	@FindBy(xpath = "(//a[@role='menuitem'])[10]//child::span")
	public static WebElement contactUs;
	
	@FindBy(xpath = "(//a[@role='menuitem'])[11]//child::span")
	public static WebElement aboutUs;
	
	@FindBy(xpath = "(//a[@role='menuitem'])[12]//child::span")
	public static WebElement blog;
	
	@FindBy(xpath = "(//a[@role='menuitem'])[13]")
	public static WebElement myAccount;
	
	@FindBy(xpath = "// i[@class='fa fa-shopping-cart']")
	public static WebElement viewCart;
	
	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	public static WebElement viewWishList;
	
	@FindBy(id = "o_logout")
	public static WebElement logOut;

}
