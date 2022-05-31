package basicAutomationCmds;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.qabible.in/payrollapp/site/login");
		Actions action=new Actions(driver);
		WebElement username=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		username.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		//action.click(login).perform();
		action.sendKeys(Keys.ENTER).perform();
		driver.close();
	}

}
