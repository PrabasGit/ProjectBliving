package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPwordPage {

	@FindBy(id = "login")
	public static WebElement resetemail;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement resetpwordbutton;
	
	@FindBy(linkText = "Back to Login")
	public static WebElement backtologinbutton;

}
