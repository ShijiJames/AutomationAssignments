package TestNGAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssignmentTestNG {
	WebDriver driver;

	public void loginToApp() {
		WebElement username = driver.findElement(By.id("loginform-username"));
		username.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@name='LoginForm[password]']"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		// applying wait until welcome page appears.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Welcome to Payroll Application']")));
	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumFiles\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.qabible.in/payrollapp/site/login");
	}

	@Test(priority = 1)
	public void verifyLoginIconDisplayed() {
		WebElement loginIcon = driver.findElement(By.tagName("h1"));
		boolean actual = loginIcon.isDisplayed();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, true);
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void verifyRemMeUnchecked() {
		WebElement remMe = driver.findElement(By.id("loginform-rememberme"));
		remMe.click();
		boolean actual = remMe.isSelected();
		Assert.assertEquals(actual, false, "Remember me is checked");
	}

	@Test(priority = 3)
	public void verifyLoginButtonColorNFont() {
		WebElement butLogin = driver.findElement(By.xpath("//button[@name='login-button']"));

		// to verify background color ; from css: background-color: #06adf3

		String bckGrdColor = butLogin.getCssValue("background-color");
		String actBkColor = Color.fromString(bckGrdColor).asHex();// to convert string value(rgba(6, 173, 243, 1))
																	// to Hexa(#06adf3)
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actBkColor, "#06adf3");

		// to verify font type ; from css: font-family: Overpass, sans-serif

		String fontFly = butLogin.getCssValue("font-family");
		softAssert.assertEquals(fontFly, "Overpass, sans-serif");
		softAssert.assertAll();
	}

	@Test(priority = 4)
	public void verifyWelcomePageTitle() {

		loginToApp();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Payroll Application", "Title not as expected");

	}

	@Test(priority = 5)
	public void verifyLoggedUserName() {

		loginToApp();

		WebElement logedUser = driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
		String user = logedUser.getText();
		Assert.assertEquals(user, "CAROL THOMAS");
	}

	@Test(priority = 6)
	public void verifyWorkerTabStatus() {

		loginToApp();
		WebElement workers = driver.findElement(By.xpath("//a[@href='/payrollapp/worker/index']"));
		workers.click();
		WebElement activeWorkerTab = driver.findElement(By.xpath("//a[@href='/payrollapp/worker/index']/parent::li"));
		// xpath used here as : child to parent

		String actualClsValue = activeWorkerTab.getAttribute("class");
		Assert.assertEquals(actualClsValue, "active");

	}

	@AfterMethod
	public void afteMethod() {
		driver.close();
	}
}
