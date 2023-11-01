package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSpecificationPage {

	@FindBy(xpath = "//button[@role='button']")
	public static WebElement addToWishList;

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	public static WebElement viewWishList;

	@FindBy(id = "add_to_cart")
	public static WebElement addToCart;

	@FindBy(xpath = "// i[@class='fa fa-shopping-cart']")
	public static WebElement viewCart;

	@FindBy(xpath = "//i[@class='fa fa-plus']")
	public static WebElement incrementProduct;

	@FindBy(xpath = "//i[@class='fa fa-minus']")
	public static WebElement decrementProduct;

}
