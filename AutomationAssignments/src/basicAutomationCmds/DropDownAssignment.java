//URL: https://demo.guru99.com/test/radio.html
//1.Open the  URL  & select any checkbox &radio button & verify the same selected.

package basicAutomationCmds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DropDownAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumFiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/radio.html");
		WebElement radiobt=driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
		radiobt.click();
		System.out.println(radiobt.isSelected());
		WebElement checkbx=driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
		checkbx.click();
		System.out.println(checkbx.isSelected());
		driver.close();
	}

}
