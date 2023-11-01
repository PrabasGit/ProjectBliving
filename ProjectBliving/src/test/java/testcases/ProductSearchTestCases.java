package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class ProductSearchTestCases {

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

	@DataProvider(name = "data")
	public String[][] data() {

		String data[][] = new String[7][1];

		data[0][0] = "agathis";         // with valid product name

		data[1][0] = "";                // with no input

		data[2][0] = "s";               // with single character

		data[3][0] = "!2";              // combination of special character & number

		data[4][0] = "asjjjkhj";        // with invalid product name

		data[5][0] = "aga this";       // with spaces

		data[6][0] = "100";            // with numbers

		return data;
	}

	@Test(dataProvider = "data")
	public void productSearch(String input) throws Exception {

		signIn();

		PageFactory.initElements(driver, MyAccountPage.class);

		MyAccountPage.home.click();

		PageFactory.initElements(driver, HomePage.class);

		HomePage.searchBox.sendKeys(input);

		Thread.sleep(2000);

		WebElement searchButton = driver.findElement(By.xpath("//div[@role='search']//child::button"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", searchButton);

	}

}
