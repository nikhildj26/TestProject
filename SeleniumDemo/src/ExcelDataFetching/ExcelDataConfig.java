package ExcelDataFetching;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	File file;
	FileInputStream fis;
	FileOutputStream fout;
	XSSFWorkbook wb;
	XSSFSheet ws;

	public ExcelDataConfig(String excelPath) {
		try {
			file = new File(excelPath);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("Error is " + e.getMessage());
		}
	}

	public String getData(String sheetName, int row, int column) {
		{
			ws = wb.getSheet(sheetName);
			String data = ws.getRow(row).getCell(column).getStringCellValue();
			return data;
		}

	}

	public int getRowCount(String sheetName) {

		int rowcount = wb.getSheet(sheetName).getLastRowNum();

		rowcount = rowcount + 1;

		return rowcount;
	}

	// Set Value in cell

	public void setData(String sheetName, String cellValue, int row, int column) throws Exception {

		ws = wb.getSheet(sheetName);
		ws.getRow(row).getCell(column).setCellValue(cellValue);
		fout = new FileOutputStream(file);
		wb.write(fout);

	}

}
