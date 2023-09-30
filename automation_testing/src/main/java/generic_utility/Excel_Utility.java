package generic_utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility
{
	/**
	 * This is used to call data form excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Afeefa
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fise = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sheet = book.getSheet(sheetName);
		Row row1 = sheet.getRow(rowNum);
		Cell cell1 = row1.getCell(cellNum);
		String ExcelData = cell1.getStringCellValue();
		return ExcelData;
	}
	
	public String getExcelDataFromDataFormatter(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fise = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		DataFormatter Formatter = new DataFormatter();
		String ExcelData = Formatter.formatCellValue(cell);
		return ExcelData;
		
	}

}
