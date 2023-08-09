package testng.dataprovider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataSetProvider {
	@DataProvider(name = "user-data-set")
	public Object[][] userDataSet(Method m) {
		Object[][] dataset = null;

		if (m.getName().equals("loginTest")) {
			return new Object[][] { 
				{ "standard_user", "secret_sauce" }, 
				{ "locked_out_user", "secret_sauce" },
				{ "problem_user", "secret_sauce" }, 
				{ "performance_glitch_user", "secret_sauce" }, 
			};
		}

		return dataset;
	}
}
