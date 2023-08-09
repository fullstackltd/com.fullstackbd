package testng.parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelTesting{
	WebDriver driver;
	@BeforeMethod
	void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}
	
	@AfterMethod
	void cleanUp() {
		driver.close();
	}
	@Test
	void test1() throws InterruptedException {
		System.out.println("Test 1: " + Thread.currentThread().getId());
		driver.get("https://www.istqb.org/");
		Thread.sleep(1000);
	}
	@Test
	void test2() throws InterruptedException {
		System.out.println("Test 2: " + Thread.currentThread().getId());
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Md Rashed Krim"+Keys.ENTER);
		Thread.sleep(1000);
	}
	@Test
	void test3() throws InterruptedException {
		System.out.println("Test 3: " + Thread.currentThread().getId());
		
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Tahsin Ayman"+Keys.ENTER);
		Thread.sleep(1000);
	}
}
