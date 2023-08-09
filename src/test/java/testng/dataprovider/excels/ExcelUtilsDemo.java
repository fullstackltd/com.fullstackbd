package testng.dataprovider.excels;

public class ExcelUtilsDemo {
	public static void main(String[] args) {
		String projectRoot = System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectRoot+"/excel/data.xlsx", "dataSheet");
		System.out.println(excel.getRowCount());
		System.out.println(excel.getColCount());
		excel.getCellDataSring(1, 0);
		excel.getCellDataNumber(1, 2);
	}
}
