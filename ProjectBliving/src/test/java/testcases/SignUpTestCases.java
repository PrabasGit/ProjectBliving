package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.SignUpPage;

public class SignUpTestCases {

	static WebDriver driver;

	public void launchURL() {

		driver = new ChromeDriver();

		driver.get("https://www.b-living.org/");
		
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "data")
	public void signUp(String email, String name, 
			String password, String confirmPassword) {

		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.createaccount.click();

		PageFactory.initElements(driver, SignUpPage.class);

		SignUpPage.email.sendKeys(email);

		SignUpPage.name.sendKeys(name);

		SignUpPage.password.sendKeys(password);

		SignUpPage.confirmPassword.sendKeys(confirmPassword);

		SignUpPage.signUp.click();
		
		closeBrowser();

	}

	@DataProvider(name = "data")
	public String[][] signUpData() {

		String data[][] = new String[6][4];

		data[0][0] = "mishael.kristoff@free2ducks.com";
		data[0][1] = "bora";
		data[0][2] = "bora@123";
		data[0][3] = "bora@123";           // With all fields

		data[1][0] = "";
		data[1][1] = "";
		data[1][2] = "";
		data[1][3] = "";                  // Without any fields

		data[2][0] = "mishael.kristoff@free2ducks.com";
		data[2][1] = "bora";
		data[2][2] = ""; 
		data[2][3] = "bora@123";          // By missing any one field

		data[3][0] = "mishael.kristoff@free2ducks.com";
		data[3][1] = "bora";
		data[3][2] = "bora@123";
		data[3][3] = "bora@12";          // With different passwords

		data[4][0] = "mishael.kristoff@free2ducks.com";
		data[4][1] = "bora";
		data[4][2] = "bora@123";
		data[4][3] = "bora@123";         // With existing email address

		data[5][0] = "mishael.kristoff@fre";
		data[5][1] = "bora";
		data[5][2] = "bora@123";
		data[5][3] = "bora@123";        // With bad email format

		return data;

	}
	
	@Test
	public void alreadyHaveAnAccount() {
		
		launchURL();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.signin.click();

		PageFactory.initElements(driver, LoginPage.class);

		LoginPage.createaccount.click();

		PageFactory.initElements(driver, SignUpPage.class);
		
		SignUpPage.alreadyHaveAccount.click();
		
		closeBrowser();
		

	}
	public void closeBrowser() {
		driver.close();
	}
}
