package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ResetPwordPage;

public class ResetPwordTestCases {

	static WebDriver driver;

	public void launchURL() {
		
		driver = new ChromeDriver();

		driver.get("https://www.b-living.org/");
	}

	@Test(dataProvider = "data")
	public void resetPword(String data) {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.resetpassword.click();

		PageFactory.initElements(driver, ResetPwordPage.class);

		ResetPwordPage.resetemail.sendKeys(data);

		ResetPwordPage.resetpwordbutton.click();

	}

	@DataProvider(name = "data")
	public String[] resetpassworddata() {

		String[] data = new String[3];

		data[0] = "lyrick.cosmo@free2ducks.com"; // with valid email

		data[1] = "lyrick.cosmo@free2ducks.comm"; // with invalid email

		data[2] = ""; // with no email

		return data;
	}

	@Test
	public void backToLogin() {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.resetpassword.click();

		PageFactory.initElements(driver, ResetPwordPage.class);

		ResetPwordPage.backtologinbutton.click();

		closeBrowser();

	}

	public void closeBrowser() {
		driver.close();
	}

}
