package poi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelPractice {

/*
FileInputStream
XSSFWorkbook
XSSFSheet
XSSFRow
XSSFCell

getStringCellValue()
getNumericCellValue()
getBooleanCellValue()

*/
	public static void main(String[] args) throws IOException {
		FileInputStream file 
		= new FileInputStream("E:/rashedkarim/eclipse-workspace/com.fullstackbd.selenium/excel/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("dataSheet");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		for (int row=0; row<rowCount;row++) {
			XSSFRow currentRow = sheet.getRow(row);
			for(int col = 0; col<colCount; col++) {
				String value = currentRow.getCell(col).toString();
				System.out.print(value+" ");
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}
}
