package genericCampaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign
{
	public static void main(String args[]) throws Throwable
	{
		Excel_Utility eu = new Excel_Utility();
		File_Utility fu = new File_Utility();
		Java_Utility ju = new Java_Utility();
		WebDriver_Utility wu = new WebDriver_Utility();
		
		//driver
		String BROWSER = fu.getCredentials("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();		
		}
		else
		{
			driver= new ChromeDriver();
		}
		
		//implicit wait
		wu.ImplicitWait(driver);
		
		//credential
		String URL = fu.getCredentials("url");
		String USERNAME = fu.getCredentials("username");
		String PASSWORD = fu.getCredentials("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//random number
		int ranNum = ju.getRandomNumber();
		
		//more
		driver.findElement(By.linkText("More")).click();
		Thread.sleep(2000);
		
		//campaign
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//create campaign
		String CampName = eu.getExcelData("Campaign", 0, 0)+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		//logout
		WebElement administrator = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wu.moveToElement(driver, administrator);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//close driver
		wu.windowClose(driver);
				
		System.out.println("testCase is Passed");
		
		
	}

}
