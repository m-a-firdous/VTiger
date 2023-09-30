package hOrganisation;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable
	{
		//driver
		WebDriver driver= new ChromeDriver();
		
		//property file
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiget.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//url, username, password LOGIN
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//organisation
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//randome number
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		//Excel file
		FileInputStream fise = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sheet = book.getSheet("Organisation");
		
		//Organisation name
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		String OrgName = cell1.getStringCellValue()+ranNum;
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		Thread.sleep(1000);
		
		//phone number
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(0);
		DataFormatter format1 = new DataFormatter();
		String PhnNum = format1.formatCellValue(cell2);
		driver.findElement(By.id("phone")).sendKeys(PhnNum);
		Thread.sleep(1000);
		
		//email
		Row row3 = sheet.getRow(2);
		Cell cell3 = row3.getCell(0);
		DataFormatter format2 = new DataFormatter();
		String Email = format2.formatCellValue(cell3);
		driver.findElement(By.id("email1")).sendKeys(Email);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//logout
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(administrator).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("testCase is Passed");

	}

}
