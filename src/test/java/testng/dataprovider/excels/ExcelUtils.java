package testng.dataprovider.excels;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String filePath, String sheetName) {
		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
	}
	

	public int getRowCount() {
			return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public String getCellDataSring(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}
	public double getCellDataNumber(int row, int col) {
		return sheet.getRow(row).getCell(col).getNumericCellValue();
	}
}
