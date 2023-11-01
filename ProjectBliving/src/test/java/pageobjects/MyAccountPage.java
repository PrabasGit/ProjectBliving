package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

	@FindBy(xpath = "//div[@class='col-12 col-md col-lg-6']//descendant::div[3]/child::a[1]")
	public static WebElement quotations;

	@FindBy(xpath = "//div[@class='col-12 col-md col-lg-6']//descendant::div[3]/child::a[2]")
	public static WebElement salesOrders;

	@FindBy(xpath = "//div[@class='col-12 col-md col-lg-6']//descendant::div[3]/child::a[5]")
	public static WebElement invoicebills;

	@FindBy(xpath = "//a[@class='btn btn-sm btn-link']")
	public static WebElement editProfile;

	@FindBy(xpath = "//a[@href='/my/security']")
	public static WebElement editSecuritySettings;

	@FindBy(xpath = "(//a[@role='menuitem'])[1]")
	public static WebElement home;
	
	
//	@FindBy(xpath = "//div[@id='o_my_sidebar']/descendant::a[3]")
//	public static WebElement editSecuritySettings;
//	
	

}
