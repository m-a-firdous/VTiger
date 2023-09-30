package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelIntegerOrStringSingleFetch
{

	public static void main(String args[]) throws Throwable
	{
		Workbook book = WorkbookFactory.create(new FileInputStream("./src/test/resources/data.xlsx"));
		Sheet sheet = book.getSheet("Sheet4");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);
		System.out.println(data);
	}
}
