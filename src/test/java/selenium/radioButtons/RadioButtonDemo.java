package selenium.radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.get("https://trytestingthis.netlify.app/");
		this.driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void radiobuttonTest() throws InterruptedException {
		WebElement radioMale = this.driver.findElement(By.id("male"));
		radioMale.click();
		Thread.sleep(4000);
		WebElement radioFemale = this.driver.findElement(By.id("female"));
		radioFemale.click();
		Thread.sleep(4000);
		WebElement radioOther = this.driver.findElement(By.id("other"));
		radioOther.click();
		Thread.sleep(4000);
		
	}
	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
