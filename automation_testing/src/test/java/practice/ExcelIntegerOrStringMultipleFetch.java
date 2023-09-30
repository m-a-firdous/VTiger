package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelIntegerOrStringMultipleFetch
{
	public static void main(String args[]) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		//Sheet sheet = book.getSheet("Sheet3"); //for multiple cell
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)//0
			{
				Cell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String data = formatter.formatCellValue(cell);
				System.out.println(data);
			}
		}
	}

}
