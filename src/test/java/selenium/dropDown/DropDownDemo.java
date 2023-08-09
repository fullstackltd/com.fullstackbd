package selenium.dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://trytestingthis.netlify.app/");
	}
	@Test
	public void dropDownTest() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.id("option"));
		Select selectObject = new Select(dropDown);
		selectObject.selectByIndex(1);
		Thread.sleep(2000);
		selectObject.selectByValue("option 2");
		Thread.sleep(2000);
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(2000);
	}
	@Test
	public void selectMultipleTest() throws InterruptedException {
		WebElement selectMultiple = driver.findElement(By.id("owc"));
		Select selectObject = new Select(selectMultiple);
		selectObject.selectByIndex(1);
		Thread.sleep(1000);
		selectObject.selectByValue("option 2");
		Thread.sleep(1000);
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(1000);
		selectObject.deselectByValue("option 2");
		Thread.sleep(2000);
	}
	@Test
	public void dataListTest() throws InterruptedException {
		WebElement dataList = driver.findElement(By.id("datalists"));
		Select selectObject = new Select(dataList);
		selectObject.selectByIndex(1);
		Thread.sleep(1000);
		selectObject.selectByValue("option 2");
		Thread.sleep(1000);
		selectObject.selectByVisibleText("Option 3");
		Thread.sleep(1000);
		selectObject.deselectByValue("option 2");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
