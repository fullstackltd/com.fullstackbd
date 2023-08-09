package selenium.booking;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BrowserHandler;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking extends BrowserHandler {
	
	@BeforeMethod
	public void launch() {
		super.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		super.driver.get("https://www.booking.com/");
	}
	@Test
	void test() {
		super.driver.findElement(By.name("ss")).click();;
	}
	
}
