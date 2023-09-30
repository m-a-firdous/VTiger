package genericCampaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

public class CreateCampainWithProduct {

	public static void main(String[] args) throws Throwable
	{
		//utilities
		Excel_Utility eu = new Excel_Utility();
		File_Utility fu = new File_Utility();
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		//driver
		WebDriver driver= new ChromeDriver();
		
		//implicit wait
		wu.ImplicitWait(driver);
		
		//maximize
		wu.windowMaximize(driver);
		
		//credential
		String URL = fu.getCredentials("url");
		String USERNAME = fu.getCredentials("username");
		String PASSWORD = fu.getCredentials("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//product
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//random number
		int ranNum = ju.getRandomNumber();
		
		//product data
		String ProdName = eu.getExcelDataFromDataFormatter("Product", 0, 0)+ranNum;
		driver.findElement(By.name("productname")).sendKeys(ProdName);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
						
		//more
		driver.findElement(By.linkText("More")).click();
						
		//campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//campaign data
		String CampName = eu.getExcelDataFromDataFormatter("Campaign", 0, 0)+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		//click on product
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//switch window
		wu.windowSwitching(driver, "Products&actions");
		Thread.sleep(2000);
		
		//select product
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProdName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		
		//switch window
		wu.windowSwitching(driver, "Campaigns&action");
		Thread.sleep(2000);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//logout
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(administrator).click().perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		wu.windowClose(driver);
		System.out.println("TestCase is Passed");
	}

}
