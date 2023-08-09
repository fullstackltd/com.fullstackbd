package testng.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testng.dataprovider.excels.ExcelDataProvider;

public class LoginTest {
	WebDriver driver;

	@DataProvider(name = "user-data-set")
	public Object[][] userDataSet() {
		return new Object[][] { { "standard_user", "secret_sauce" }, { "problem_user", "secret_sauce" },
				{ "performance_glitch_user", "secret_sauce" }, };
	}

	@Parameters({"browser"})
	@BeforeMethod
	public void launchBrowser(String browser) {
		System.out.println(browser);
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			this.driver = new ChromeDriver(options);
			this.driver.get("https://www.saucedemo.com/");
		}else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			this.driver = new EdgeDriver(options);
			this.driver.get("https://www.saucedemo.com/");
		}
		
	}
	
	@AfterMethod
	public void tearDownBrowser() {
		this.driver.close();
	}
	
//	@Test(dataProviderClass = DataSetProvider.class, dataProvider = "user-data-set")
	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "user-data-set")
	public void loginTest(String username, String password) {
		try {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			Boolean logoutLink = driver.findElement(By.id("logout_sidebar_link")).isDisplayed();
			Assert.assertTrue(logoutLink);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
