package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LoginTestCases {

	static WebDriver driver;

	private void launchURL() {
		driver = new ChromeDriver();
		driver.get("https://www.b-living.org/");
	}

	@Test(dataProvider = "logindata")
	public void login(String email, String password) {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.email.sendKeys(email);
		
		LoginPage.password.sendKeys(password);
		
		LoginPage.login.click();
		
		closeBrowser();

	}

	@DataProvider(name = "logindata" , indices = {4})
	
	public String[][] logintestdata() {

		String[][] data = new String[7][2];

		data[0][0] = "lyrick.cosmo@free2ducks.com";
		data[0][1] = "lyrik@123"; // Valid email & valid password

		data[1][0] = "lyrick.cosmo@free2ducks.comm";
		data[1][1] = "lyrik@123"; // Invalid email & valid password

		data[2][0] = "lyrick.cosmo@free2ducks.com";
		data[2][1] = "lyrik@124"; // Valid email & Invalid password

		data[3][0] = "lyrick.cosmo@free2ducks.comm";
		data[3][1] = "lyrik@126"; // Invalid email & Invalid password

		data[4][0] = "";
		data[4][1] = ""; // No data

		data[5][0] = "lyrick.cosmo@free2ducks.com";
		data[5][1] = ""; // Providing only email

		data[6][0] = "";
		data[6][1] = "lyrik@123"; // Providing only password

		return data;

	}

	@Test
	public void createAccount() {
		
		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.createaccount.click();
		
		closeBrowser();

	}

	@Test
	public void resetPassword() {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.resetpassword.click();
		
		closeBrowser();

	}

	public void closeBrowser() {
		
		driver.close();
		
	}

}