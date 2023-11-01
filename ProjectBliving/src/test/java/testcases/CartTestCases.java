package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductSpecificationPage;

public class CartTestCases {

	static WebDriver driver;

	public void launchURL() {

		driver = new ChromeDriver();

		driver.get("https://www.b-living.org/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void signIn() {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.email.sendKeys("mishael.kristoff@free2ducks.com");

		LoginPage.password.sendKeys("bora@1234");

		LoginPage.login.click();

	}

	public void productDetails() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.home.click();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.searchBox.sendKeys("klinto");

		WebElement searchButton = driver.findElement(By.xpath("//div[@role='search']//child::button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", searchButton);

		driver.findElement(By.linkText("Klinto Trigger 500 ml")).click();

	}

	public void viewCart() {

		productDetails();

		PageFactory.initElements(driver, ProductSpecificationPage.class);

		ProductSpecificationPage.viewCart.click();

	}

	@Test
	public void incrementProductFromCart() throws Exception {

		viewCart();

		PageFactory.initElements(driver, CartPage.class);

		WebElement incrementProduct = CartPage.incrementProduct;

		for (int i = 0; i < 2; i++) {

			incrementProduct.click();

			Thread.sleep(2000);

		}

	}

	@Test
	public void decrementProductFromCart() throws Exception {

		viewCart();

		PageFactory.initElements(driver, CartPage.class);

		WebElement decrementProduct = CartPage.decrementProduct;

		for (int i = 0; i < 2; i++) {

			decrementProduct.click();

			Thread.sleep(2000);

		}

	}

	@Test
	public void processCheckOut() {

		viewCart();

		PageFactory.initElements(driver, CartPage.class);

		CartPage.processCheckOut.click();

	}

	@Test
	public void proceedToCheckOut() {

		viewCart();

		PageFactory.initElements(driver, CartPage.class);

		CartPage.proceedToCheckOut.click();

	}
	
	@Test
	public void removeProductFromCart() {

		viewCart();

		PageFactory.initElements(driver, CartPage.class);

		CartPage.removeProduct.click();

	}

}
