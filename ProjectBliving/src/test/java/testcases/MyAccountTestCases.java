package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class MyAccountTestCases {

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

	@Test
	public void verifyQuotations() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.quotations.click();

	}

	@Test
	public void verifySalesOrders() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.salesOrders.click();

	}

	@Test

	public void verifyInvoiceBills() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.invoicebills.click();

	}

	@Test
	public void verifyEditProfile() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

	}

	@Test
	public void verifyEditSecuritySettings() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editSecuritySettings.click();

	}

	@Test
	public void logout() throws Exception {

		signIn();

		WebElement logout = driver.findElement(By.xpath("(//a[@role='button'])[1]//following::div[1]//child::a[2]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", logout);

	}

}
