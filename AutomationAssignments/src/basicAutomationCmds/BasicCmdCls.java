package basicAutomationCmds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Assignment1 (Date:24/03/2022)
//Url:https://demo.guru99.com/test/newtours/
//1.Enter UserName 2.Enter password 3. Click Login Button
//---------------------------***************------------------------------

public class BasicCmdCls {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		username.sendKeys("test");
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("test");
		WebElement login = driver.findElement(By.xpath("//input[@name='submit']"));
		login.click();
		driver.close();

	}

}
