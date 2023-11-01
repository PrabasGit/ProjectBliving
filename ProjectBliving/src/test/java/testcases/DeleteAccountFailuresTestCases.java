package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.SecurityPage;

public class DeleteAccountFailuresTestCases {

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

		LoginPage.email.sendKeys("tenim27870@elixirsd.com");

		LoginPage.password.sendKeys("ten");

		LoginPage.login.click();

	}

	public void verifyEditSecuritySettings() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editSecuritySettings.click();

	}
	

	@DataProvider(name = "data" )
	public String[][] data() {

		String[][] data = new String[3][2];

		data[0][0] = "";
		data[0][1] = ""; // with no input

		data[1][0] = "te";
		data[1][1] = "tenim27870@elixirsd.com"; // with wrong password

		data[2][0] = "ten";
		data[2][1] = "tenim27870@elixirsd.co"; // with wrong email

		return data;

	}

	@Test(dataProvider = "data")
	public void deleteAccountFailures(String password , String email) {

		verifyEditSecuritySettings();

		PageFactory.initElements(driver, SecurityPage.class);

		SecurityPage.deleteAccount.click();

		SecurityPage.enterPassword.sendKeys(password);

		SecurityPage.enterEmail.sendKeys(email);

		SecurityPage.confirmDeleteAccount.click();

	}

}
