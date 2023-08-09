package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandler {
	
	protected WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		this.driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
