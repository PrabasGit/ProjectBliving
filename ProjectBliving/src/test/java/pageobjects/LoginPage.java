package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(id="login")
	public static WebElement email;
	
	@FindBy(id="password")
	public static WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement login;
	
	@FindBy(linkText = "Don't have an account?")
	public static WebElement createaccount;
	
	@FindBy(linkText = "Reset Password")
	public static WebElement resetpassword;
	



}
