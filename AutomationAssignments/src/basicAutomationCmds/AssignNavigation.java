package basicAutomationCmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignNavigation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("loginform-username"));
		username.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@name='LoginForm[password]']"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();

		// 1.)login and navigate to client tab-->click "Create Client" options from
		// "Branch","Invoice Order","Division" drop-down-->get the selected values from
		// the drop-down and print the same

		Thread.sleep(3000);
		//WebElement title=driver.findElement(By.tagName("title"));
		WebElement clientTab = driver.findElement(By.linkText("Clients"));
		clientTab.click();
		// WebElement createClient = driver.findElement(By.linkText("Create Client"));
		WebElement createClient = driver.findElement(By.xpath("//a[text()='Create Client']"));
		createClient.click();
		Thread.sleep(3000);
		WebElement branch = driver.findElement(By.xpath("//select[@id='client-branch_id']"));
		Select branchdp = new Select(branch);
		branchdp.selectByIndex(1);
		WebElement branchop = branchdp.getFirstSelectedOption();
		System.out.println("Branch  =" + branchop.getText());

		WebElement invoice = driver.findElement(By.xpath("//select[@id='client-invoice_order']"));
		Select invoicedp = new Select(invoice);
		invoicedp.selectByIndex(1);
		WebElement invoiceop = invoicedp.getFirstSelectedOption();
		System.out.println("Invoice Order  =" + invoiceop.getText());

		WebElement division = driver.findElement(By.xpath("//select[@name='Client[division_id]']"));
		Select divisiondp = new Select(division);
		divisiondp.selectByIndex(1);
		WebElement divisionop = divisiondp.getFirstSelectedOption();
		System.out.println("Division  =" + divisionop.getText());

		// 2.)login and navigate to client tab-->click "Create Client" options
		// -->get the tagname of "Create Client" sub menu option and print the same

		// WebElement crtClnt = driver.findElement(By.linkText("Create Client"));
		System.out.println("Create Client tagname is " + createClient.getTagName());

		// 3.) Get the font type and font size of "Create Client"sub menu and print the
		// same

		// System.out.println("Create Client Tag Font type is " +
		// crtClnt.getCssValue("font-family"));
		// System.out.println("Create Client Tag Font size is " +
		// crtClnt.getCssValue("font-size"));

		// 4.)Navigate to workers tab--> Click "Create Worker"sub menu--
		// get the value of the "href" attribute from the "Create Worker' sun menu and
		// print the same.

		WebElement worker = driver.findElement(By.linkText("Workers"));
		worker.click();
		WebElement createwrk = driver.findElement(By.linkText("Create Worker"));
		System.out.println(createwrk.getAttribute("href"));

		// 5.)Get the text of the "Create Worker" sub menu and print the same

		System.out.println(createwrk.getText());
		// driver.close();

	}

}
