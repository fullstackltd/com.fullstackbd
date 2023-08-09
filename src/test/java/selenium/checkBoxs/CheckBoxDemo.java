package selenium.checkBoxs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		this.driver.get("https://trytestingthis.netlify.app/");
		this.driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void checkBoxTest() throws InterruptedException {
		WebElement option1 = this.driver.findElement(By.name("option1"));
		option1.click();
		Thread.sleep(4000);
		WebElement option2 = this.driver.findElement(By.name("option2"));
		option2.click();
		Thread.sleep(4000);
		WebElement option3 = this.driver.findElement(By.name("option3"));
		option3.click();
		Thread.sleep(4000);
		option2.click();
		Thread.sleep(4000);
	}

	@Test
	void datePickerHTML5() throws InterruptedException {
		// date select
		WebElement datepick = driver.findElement(By.xpath("//*[@id=\"day\"]"));
		datepick.click();
		datepick.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
		datepick.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
