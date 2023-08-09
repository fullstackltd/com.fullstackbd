package selenium.windows.newWindows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class NewWindowHandle extends BrowserHandler {

	@Test
	public void test() throws InterruptedException {
		driver.get("https://www.salesforce.com/au/");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/section/div[1]/article/div[2]/div/pbc-button[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		Iterator<String> iterator = windowHandles.iterator();
		String childWindow = iterator.next();
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.name("UserFirstName")).sendKeys("Rashed");
		driver.findElement(By.name("UserLastName")).sendKeys("Karim");
		WebElement jobTitle = driver.findElement(By.id("UserTitle-tMJY"));
		Select selectJobTitle = new Select(jobTitle);
		selectJobTitle.selectByVisibleText("IT Manager");
		driver.findElement(By.id("UserEmail-F5JR")).sendKeys("mail4rashed@gmail.com");
		Thread.sleep(2000);
	}
}
