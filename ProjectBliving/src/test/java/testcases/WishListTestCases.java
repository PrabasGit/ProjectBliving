package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.ProductSpecificationPage;
import pageobjects.WishListPage;

public class WishListTestCases extends ProductSpecificationTestCases {

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

	@Test
	public void addToCartFromWishList() {

		productDetails();

		PageFactory.initElements(driver, ProductSpecificationPage.class);

		ProductSpecificationPage.viewWishList.click();

		PageFactory.initElements(driver, WishListPage.class);

		WishListPage.addToCart.click();

	}

	@Test
	public void removeProductFromWishList() {

		productDetails();
		
		PageFactory.initElements(driver, ProductSpecificationPage.class);

		ProductSpecificationPage.viewWishList.click();

		PageFactory.initElements(driver, WishListPage.class);

		WishListPage.removeButton.click();

	}

}
