package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageobjects.EditProfilePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class EditProfileTestCases {

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
	public void withNoFields() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

		PageFactory.initElements(driver, EditProfilePage.class);

		EditProfilePage.companyName.sendKeys("");

		EditProfilePage.vat.sendKeys("");

		EditProfilePage.phone.sendKeys("");

		EditProfilePage.street.sendKeys("");

		EditProfilePage.city.sendKeys("");

		EditProfilePage.postalCode.sendKeys("");

		EditProfilePage.upsAccountNumber.sendKeys("");

		EditProfilePage.confirm.click();

	}

	@Test
	public void withMandatoryFields() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

		PageFactory.initElements(driver, EditProfilePage.class);

		EditProfilePage.phone.sendKeys("9876543210");

		EditProfilePage.street.sendKeys("Dubai Street");

		EditProfilePage.city.sendKeys("Dubai");

		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));

		Select select = new Select(country);

		select.selectByValue("104");

		EditProfilePage.confirm.click();
	}

	@Test
	public void withLeavingOneField() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

		PageFactory.initElements(driver, EditProfilePage.class);

		EditProfilePage.companyName.sendKeys("ABC");

		EditProfilePage.vat.sendKeys("123456");

		EditProfilePage.postalCode.sendKeys("856892");

		EditProfilePage.confirm.click();

	}

	@Test
	public void withAllFields() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

		PageFactory.initElements(driver, EditProfilePage.class);

		WebElement state = driver.findElement(By.xpath("//select[@name='state_id']"));

		Select select = new Select(state);

		select.selectByValue("579");

		EditProfilePage.upsAccountNumber.sendKeys("123456");

		EditProfilePage.confirm.click();

	}

	@Test
	public void editCompleteProfile() {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.editProfile.click();

		PageFactory.initElements(driver, EditProfilePage.class);

		EditProfilePage.companyName.clear();

		EditProfilePage.companyName.sendKeys("ABCD");

		EditProfilePage.vat.clear();

		EditProfilePage.vat.sendKeys("12345");

		EditProfilePage.phone.clear();

		EditProfilePage.phone.sendKeys("9768543210");

		EditProfilePage.street.clear();

		EditProfilePage.street.sendKeys("ABC street");

		EditProfilePage.city.clear();

		EditProfilePage.city.sendKeys("Dubai");

		EditProfilePage.postalCode.clear();

		EditProfilePage.postalCode.sendKeys("892856");

		WebElement country = driver.findElement(By.xpath("//select[@name='country_id']"));

		Select select = new Select(country);

		select.selectByValue("2");

		WebElement state = driver.findElement(By.xpath("//select[@name='state_id']"));

		Select select1 = new Select(state);

		select1.selectByValue("548");

		EditProfilePage.upsAccountNumber.clear();

		EditProfilePage.upsAccountNumber.sendKeys("12345");

		EditProfilePage.confirm.click();

	}

}
