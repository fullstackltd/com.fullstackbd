package selenium.pageloading;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadingDemo {
	private WebDriver driver;
	private ChromeOptions options;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();	
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	@Test(priority=1)
	public void normalLoad() {
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		System.out.println("Normal");
		driver.get("https://google.com");
	}
	@Test(priority=2)
	public void eagerLoad() {
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		System.out.println("Eager");
		driver.get("https://google.com");
	}
	@Test(priority=3)
	public void noneLoad() {
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		System.out.println("None");
		driver.get("https://google.com");
	}
	
	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
