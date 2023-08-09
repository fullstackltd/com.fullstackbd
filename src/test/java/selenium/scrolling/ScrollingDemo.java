  package selenium.scrolling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class ScrollingDemo extends BrowserHandler {
	private JavascriptExecutor js;

	@BeforeMethod
	public void launchURL() {
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_area");
		this.js = (JavascriptExecutor) this.driver;
	}
	@Test(priority = 1)
	public void ScrollingByPixel() throws InterruptedException {
		// Scenario 1: Scroll down the web page by pixel
		this.js.executeScript("window.scrollBy(0, 700)","");
		Thread.sleep(4000);
	}
	@Test(priority = 2)
	public void ScrollingByVisibleElement() throws InterruptedException {
		// Scenario 2: Scroll down the web page by the visibility of the element
		WebElement bd = driver.findElement(By.xpath("//a[@href='/wiki/Bangladesh']"));
		this.js.executeScript("arguments[0].scrollIntoView();", bd);
		Thread.sleep(4000);
	}
	
	@Test(priority = 3)
	public void ScrollingToButtonOfThePage() throws InterruptedException {
		// Scenario 3: Scroll down the web page at bottom of the page
		this.js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		Thread.sleep(4000);
	}

}
