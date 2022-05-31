package basicAutomationCmds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentWaits {

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.qabible.in/payrollapp/site/login");
		WebElement username = driver.findElement(By.xpath("//input[@id='loginform-username']"));
		username.sendKeys("carol");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		login.click();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement worker = driver.findElement(By.xpath("//a[text()='Workers']"));
		worker.click();
		// explicit wait for Create Worker
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Create Worker")));
		WebElement createWorker=driver.findElement(By.xpath("//a[text()='Create Worker']"));
		createWorker.click();
		
		// explicit wait for text"Next" to be present in the "Next" button
		
		
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@class='btn btn-success']"),"Next"));
		
		WebElement deductionMain=driver.findElement(By.xpath("//a[text()='Deduction']"));
		deductionMain.click();
		WebElement litag=driver.findElement(By.xpath("//ul[@id='w2']/li[@class='active']"));
	
		wait.until(ExpectedConditions.attributeContains(litag, "class", "active"));
		System.out.println("done");
	}

}
