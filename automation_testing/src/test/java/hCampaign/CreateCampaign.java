package hCampaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampaign {

	public static void main(String[] args) throws Throwable
	{
		//driver
		WebDriver driver= new ChromeDriver();
		
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
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
		
		//more
		driver.findElement(By.linkText("More")).click();
		
		//campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//data
		FileInputStream fise = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		Sheet sheet = book.getSheet("Campaign");
		Row row1 = sheet.getRow(0);
		Cell cell1 = row1.getCell(0);
		String CampName = cell1.getStringCellValue();
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//logout
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(administrator).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("TestCase is Passed");

	}

}
