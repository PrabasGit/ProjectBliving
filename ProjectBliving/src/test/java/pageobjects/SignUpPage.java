package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	
	@FindBy(id="login")
	public static WebElement email;
	
	@FindBy(id="name")
	public static WebElement name;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(id="confirm_password")
	public static WebElement confirmPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement signUp;
	
	@FindBy(linkText ="Already have an account?")
	public static WebElement alreadyHaveAccount;
}
