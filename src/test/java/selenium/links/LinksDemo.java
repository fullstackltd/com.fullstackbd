package selenium.links;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BrowserHandler;

public class LinksDemo extends BrowserHandler {

	@Test
	public void linksPrint() {
		driver.get("https://jqueryui.com/");
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total tags are : "+alltags.size());
		
		for(int i = 0; i<alltags.size(); i++) {
			WebElement tags = alltags.get(i);
			String href = tags.getAttribute("href");
			System.out.println("<"+tags.getTagName()+" href=\""+href+"\">"+tags.getText()+"</a>");
		}
	}
}
