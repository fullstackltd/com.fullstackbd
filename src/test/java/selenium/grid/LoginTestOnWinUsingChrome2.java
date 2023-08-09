package selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.dataprovider.excels.ExcelDataProvider;

public class LoginTestOnWinUsingChrome2 {

	WebDriver driver;

	@BeforeMethod
	void setup() throws MalformedURLException {
		String nodeURL = "http://localhost:4444/";
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		this.driver = new RemoteWebDriver(new URL(nodeURL), options);
	}

	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider ="user-data-set")
	void loginTest(String username, String password) throws InterruptedException {
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
