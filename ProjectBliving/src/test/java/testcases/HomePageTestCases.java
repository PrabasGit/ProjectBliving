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

public class HomePageTestCases {

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

	public void home() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.home.click();

	}

	@Test
	public void brandsDropdown() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		WebElement brandDropdown = HomePage.brandDropdown;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", brandDropdown);

	}

	@Test
	public void shopDropdown() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		WebElement shopDropdown = HomePage.shopDropdown;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", shopDropdown);

	}

	@Test
	public void viewCart() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.viewCart.click();

	}

	@Test
	public void viewWishlist() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.viewWishList.click();

	}

	@Test
	public void locherberCollections() {

		home();

		driver.findElement(By.xpath("(//a[text()='View All Collections'])[1]")).click();

	}

	@Test
	public void teatroCollections() {

		home();

		driver.findElement(By.xpath("(//a[text()='View All Collections'])[2]")).click();

	}

	@Test
	public void aromiereCollections() {

		home();

		driver.findElement(By.xpath("(//a[text()='View All Collections'])[3]")).click();

	}

	@Test
	public void aromierePetCollections() {

		home();

		driver.findElement(By.xpath("(//a[text()='View All Collections'])[4]")).click();

	}

	@Test
	public void myAccount() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		WebElement myaccount = HomePage.myAccount;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", myaccount);

	}

	@Test
	public void logOut() {

		home();

		PageFactory.initElements(driver, HomePage.class);

		WebElement logOut = HomePage.logOut;

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", logOut);

	}

}
