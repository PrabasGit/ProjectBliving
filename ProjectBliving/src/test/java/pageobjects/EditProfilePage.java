package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfilePage {

	@FindBy(xpath = "//input[@type='text']")
	public static WebElement name;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	public static WebElement companyName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	public static WebElement vat;
	
	@FindBy(xpath = "//input[@type='tel']")
	public static WebElement phone;
	
	@FindBy(xpath = "(//input[@type='text'])[4]")
	public static WebElement street;
	
	@FindBy(xpath = "(//input[@type='text'])[5]")
	public static WebElement city;
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	public static WebElement postalCode;
	
	@FindBy(xpath = "(//input[@type='text'])[7]")
	public static WebElement upsAccountNumber;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement confirm;

}
