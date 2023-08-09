package orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class OrangeHRMTest extends BrowserHandler {

	@Test
	public void LoginTest() {
		try {
			this.driver.get("https://opensource-demo.orangehrmlive.com/");
			
			Thread.sleep(1000);
			this.driver.findElement(By.name("username")).sendKeys("Admin");
			this.driver.findElement(By.name("password")).sendKeys("admin123");
			this.driver.findElement(By.xpath("//button[\"type='submit'\"]")).click();
			Thread.sleep(2000);
			this.driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
			Thread.sleep(2000);
			this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
			Thread.sleep(2000);
			this.driver.findElement(By.name("firstName")).sendKeys("Rashed");
			this.driver.findElement(By.name("middleName")).sendKeys("Kariim");
			this.driver.findElement(By.name("lastName")).sendKeys("Joudge");
			Thread.sleep(2000);
			this.driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) this.driver;
			jse.executeScript("scrollBy(0, 4000)");
			Thread.sleep(5000);
			this.driver.navigate().back();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
