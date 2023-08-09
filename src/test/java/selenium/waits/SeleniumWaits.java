package selenium.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class SeleniumWaits extends BrowserHandler {

	@Test(description = "Selenium Wait Test 1")
	public void waitTest1() throws InterruptedException {
		driver.get("https://www.easemytrip.com/");
		driver.findElement(By.id("FromSector_show")).click();
		driver.findElement(By.id("a_FromSector_show")).sendKeys("Dhaka", Keys.ENTER);
		driver.findElement(By.id("Editbox13_show")).click();
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("kuala lumpur international Airport", Keys.ENTER);
		driver.findElement(By.id("ddate")).click();
		driver.findElement(By.id("snd_4_06/04/2023")).click();
		driver.findElement(By.className("srchBtnSe")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		Thread.sleep(5000);
	}
	@Test(description = "Selenium Wait Test 2")
	public void explicitWait4VisibilityOfElement() throws InterruptedException {
		driver.get("https://www.ebay.com.au/");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[3]/a"))).click();
		Thread.sleep(5000);
	}
	@Test(description = "Selenium Wait Test 3")
	public void explicitWait4VisibilityOfElement1() throws InterruptedException {
		driver.get("https://www.ebay.com.au/");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[3]/a")).click();
	}
}
