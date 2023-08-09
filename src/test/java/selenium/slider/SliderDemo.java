package selenium.slider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class SliderDemo extends BrowserHandler {
	
	@Test(description = "Selenium Slider Test 1")
	public void sliderTest() throws InterruptedException {
		driver.get("https://jqueryui.com/slider/#colorpicker");
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		WebElement greenSlider = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
		Actions action = new Actions(driver);
		Thread.sleep(2000); 
		action.dragAndDropBy(greenSlider, 100, 125).perform();
		Thread.sleep(2000);
		action.dragAndDropBy(greenSlider, -100, 125).perform();
		Thread.sleep(2000);
	}

}
