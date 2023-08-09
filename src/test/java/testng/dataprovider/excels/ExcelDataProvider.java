package testng.dataprovider.excels;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

	@Test(dataProvider = "user-data-set")
	public void myTest(String username, String password) {
		System.out.println(username+" | "+password);
	}
	
	@DataProvider(name="user-data-set")
	public Object[][] getData() {
		String filePath = "E:/rashedkarim/eclipse-workspace/com.fullstackbd/excel/data.xlsx";
		Object data[][] = testData(filePath, "dataSheet");
		return data;
	}
	
	public static Object[][] testData(String filePath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(filePath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int row = 1; row<rowCount; row++) {
			for(int col = 0; col<colCount; col++) {
				String cellData = excel.getCellDataSring(row, col);
//				System.out.print(cellData + "| ");
				data[row-1][col] = cellData;
			}
//			System.out.println();
		}
		return data;
	}
}
