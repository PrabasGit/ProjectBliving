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

public class ChangePasswordFailuresTestCases {

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

	@Test
	public void verifyEditSecuritySettings() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editSecuritySettings.click();

	}

	@DataProvider(name = "data" , indices= {4})
	public String[][] data() {

		String[][] data = new String[5][3];

		data[0][0] = "";
		data[0][1] = "";
		data[0][2] = ""; // with no fields

		data[1][0] = "ten";
		data[1][1] = "ten1";
		data[1][2] = "ten"; // with mismatch password

		data[2][0] = "ten";
		data[2][1] = "";
		data[2][2] = "ten"; // by leaving one field

		data[3][0] = "ten";
		data[3][1] = "ten";
		data[3][2] = "ten"; // with existing password

		data[4][0] = "te";
		data[4][1] = "ten@123";
		data[4][2] = "ten@123"; // by providing wrong current password

		return data;

	}

	@Test(dataProvider = "data")
	public void changePasswordFailures(String cpassword, String nPassword, String cnpassword) {

		verifyEditSecuritySettings();                                                                                                    

		PageFactory.initElements(driver, SecurityPage.class);

		SecurityPage.password.sendKeys(cpassword); // current password

		SecurityPage.newPassword.sendKeys(nPassword); // New password

		SecurityPage.verifyNewPassword.sendKeys(cnpassword); // Verify new password

		SecurityPage.ChangePassword.click();

	}

}
