package testng.dataprovider;

import org.testng.annotations.DataProvider;

public class browserProvider {
	@DataProvider(name="browser-list")
	public Object[][] browserDataSet() {
		return new Object[][] { 
			{ "chrome" }, 
			{ "edge" },
		 };
	}
}
