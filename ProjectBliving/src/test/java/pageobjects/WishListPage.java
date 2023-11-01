package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage {
	
	@FindBy(xpath = "(//button[@type='button'])[2]")
	public static WebElement removeButton;
	
	@FindBy(id = "add_to_cart_button")
	public static WebElement addToCart;


}
