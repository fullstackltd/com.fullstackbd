package selenium.alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	   
	@Test(priority=1)
	public void alertTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); 
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You successfully clicked an alert"))
			System.out.println("You successfully clicked an alert");
		System.out.println("=================");
	}
	@Test(priority=2)
	public void alertConfirmTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();  
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You clicked: Cancel"))
			System.out.println("You clicked: Cancel");
		System.out.println("=================");
	}
	@Test(priority=3)
	public void alertPromptTest() throws InterruptedException {
		driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.sendKeys("rashed");
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		if(driver.getPageSource().contains("You entered: rashed"))
			System.out.println("You entered: rashed");
		System.out.println("=================");
	}
	
	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}
	
}
