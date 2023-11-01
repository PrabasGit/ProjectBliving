package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	public static WebElement incrementProduct;

	@FindBy(xpath = "//i[@class='fa fa-minus']")
	public static WebElement decrementProduct;

	@FindBy(linkText = "Process Checkout")
	public static WebElement processCheckOut;

	@FindBy(linkText = "Proceed to Checkout")
	public static WebElement proceedToCheckOut;
	
	@FindBy(xpath = "//i[@class='fa fa-trash-o']")
	public static WebElement removeProduct;

}
