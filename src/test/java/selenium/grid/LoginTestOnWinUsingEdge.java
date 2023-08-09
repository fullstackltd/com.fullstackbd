package selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestOnWinUsingEdge {

	WebDriver driver;

	@BeforeMethod
	void setup() throws MalformedURLException {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		String nodeURL = "http://localhost:4444/";
		//caps.setCapability(CapabilityType.BROWSER_NAME, "edge");
		this.driver = new RemoteWebDriver(new URL(nodeURL), options);
	}

	@Test
	void loginTest() throws InterruptedException {
		String username = "standard_user", password = "secret_sauce";
		this.driver.get("https://www.saucedemo.com/");
		this.driver.findElement(By.id("user-name")).sendKeys(username);
		this.driver.findElement(By.id("password")).sendKeys(password);
		this.driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		Boolean logoutLink = driver.findElement(By.id("logout_sidebar_link")).isEnabled();
		Assert.assertTrue(logoutLink);
	}

	@AfterMethod
	public void tearDownBrowser() {
		this.driver.close();
		this.driver.quit();
	}
}
