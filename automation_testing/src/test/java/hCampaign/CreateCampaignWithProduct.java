package hCampaign;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateCampaignWithProduct {

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
				
		//product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//randome number
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
				
		//data from excel
		FileInputStream fisp = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book1 = WorkbookFactory.create(fisp);
		Sheet sheet1 = book1.getSheet("Product");
		Row row1 = sheet1.getRow(0);
		Cell cell1 = row1.getCell(0);
		String ProdName = cell1.getStringCellValue()+ranNum;
		driver.findElement(By.name("productname")).sendKeys(ProdName);
				
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
				
		//more
		driver.findElement(By.linkText("More")).click();
				
		//campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
				
		//data
		FileInputStream fisc = new FileInputStream("./src/test/resources/VtigerData.xlsx");
		Workbook book2 = WorkbookFactory.create(fisc);
		Sheet sheet2 = book2.getSheet("Campaign");
		Row row2 = sheet2.getRow(0);
		Cell cell2 = row2.getCell(0);
		String CampName = cell2.getStringCellValue()+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
				
		//product name
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//windows handling/changing
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while(id.hasNext())
		{
			String window = id.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			
			if(title.contains("Products&actions"))
			{
				break;
			}
		}
		Thread.sleep(2000);
		
		//select product
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		
		//window change
		Set<String> allWindows1 = driver.getWindowHandles();
		Iterator<String> id1 = allWindows1.iterator();
		while(id1.hasNext())
		{
			String window = id1.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			
			if(title.contains("Campaigns&action"))
			{
				break;
			}
		}
		Thread.sleep(2000);
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
