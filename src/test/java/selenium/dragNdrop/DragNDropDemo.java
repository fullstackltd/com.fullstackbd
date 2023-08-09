package selenium.dragNdrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragNDropDemo {

	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(options);
		this.driver.get("https://jqueryui.com/droppable/");
//		this.driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void dragDropTest() throws InterruptedException {
		WebElement frame = this.driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		this.driver.switchTo().frame(frame);
		
		WebElement drag = this.driver.findElement(By.id("draggable"));
		WebElement drop = this.driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(this.driver);
		Thread.sleep(4000);
		action.dragAndDrop(drag, drop).perform();
		Thread.sleep(4000);
	}

	@AfterMethod
	public void tearDown() {
		this.driver.close();
	}
}
