package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurityPage {

	@FindBy(id = "current")
	public static WebElement password;

	@FindBy(id = "new")
	public static WebElement newPassword;

	@FindBy(id = "new2")
	public static WebElement verifyNewPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement ChangePassword;
	
	@FindBy(xpath = "//button[@data-bs-toggle='modal']")
	public static WebElement deleteAccount;
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement enterPassword;
	
	@FindBy(xpath = "//input[@name='validation']")
	public static WebElement enterEmail;
	
	@FindBy(xpath = "//button[@class='btn']")
	public static WebElement deleteAccountCancelButton;
	
	@FindBy(xpath = "//input[@value='Delete Account']")
	public static WebElement confirmDeleteAccount;
	
	
	
	

}
