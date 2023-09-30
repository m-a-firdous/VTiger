package hProduct;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductAndDelete
{public static void main(String[] args) throws Throwable
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
	
	//product
	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	//randome number
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	
	//data from excel
	FileInputStream fise = new FileInputStream("./src/test/resources/VtigerData.xlsx");
	Workbook book = WorkbookFactory.create(fise);
	Sheet sheet = book.getSheet("Product");
	Row row1 = sheet.getRow(0);
	Cell cell1 = row1.getCell(0);
	String ProdName = cell1.getStringCellValue()+ranNum;
	driver.findElement(By.name("productname")).sendKeys(ProdName);
	
	//save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	
	//product
	driver.findElement(By.linkText("Products")).click();
	
	//select product
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProdName+"']/../preceding-sibling::td/input")).click();
	
	//delete
	driver.findElement(By.xpath("//input[@value='Delete']")).click();
	
	//alert popup
	Alert alert = driver.switchTo().alert();
	alert.accept();
	Thread.sleep(2000);
	
	//logout
	WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(administrator).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	System.out.println("TestCase is Passed");
	}

}
