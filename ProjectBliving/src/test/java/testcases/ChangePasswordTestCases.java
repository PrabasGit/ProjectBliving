package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.SecurityPage;

public class ChangePasswordTestCases {

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

	public void verifyEditSecuritySettings() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editSecuritySettings.click();

	}

	@Test
	public void changePasswordSuccess() {

		verifyEditSecuritySettings();

		PageFactory.initElements(driver, SecurityPage.class);

		SecurityPage.password.sendKeys("bora@123");

		SecurityPage.newPassword.sendKeys("bora@1234");

		SecurityPage.verifyNewPassword.sendKeys("bora@1234");

		SecurityPage.ChangePassword.click();

	}

}
