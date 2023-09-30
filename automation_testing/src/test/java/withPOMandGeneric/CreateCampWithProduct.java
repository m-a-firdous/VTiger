package withPOMandGeneric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POM_Repository.CampaignPage;
import POM_Repository.HomePage;
import POM_Repository.LoginPage;
import POM_Repository.ProductPage;
import POM_Repository.ProductWindowInCampaign;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampWithProduct
{
	@Test
	public void CreateCampWithProduct() throws Throwable
{
	//utilities
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
	
	//maximize
	wu.windowMaximize(driver);
	
	//random number
	int ranNum = ju.getRandomNumber();
	
	//credential
	String URL = fu.getCredentials("url");
	String USERNAME = fu.getCredentials("username");
	String PASSWORD = fu.getCredentials("password");
	driver.get(URL);
	LoginPage login = new LoginPage(driver);
	login.loginToVtiger(USERNAME, PASSWORD);
	
	//product
	HomePage home = new HomePage(driver);
	home.clickProductLink(driver);
	
	//create product
	ProductPage CreateProduct= new ProductPage(driver);
	String ProdName = eu.getExcelDataFromDataFormatter("Product", 0, 0)+ranNum;
	CreateProduct.CreateProduct(driver, ProdName);
	
	//campaign link
	home.clickMoreLinkForCampaign(driver);
	
	//campaign page
	CampaignPage Createcamp = new CampaignPage(driver);
	String CampName = eu.getExcelData("Campaign", 0, 0)+ranNum;
	Createcamp.getCreateCampPlusSign().click();
	Createcamp.getCampName().sendKeys(CampName);
	
	//product
	ProductWindowInCampaign ProdCamp = new ProductWindowInCampaign(driver);
	ProdCamp.Product(driver, ProdName, wu);
	Thread.sleep(1000);
	ProdCamp.SelectProduct(driver, ProdName, wu);
	
	home.clickAdministerLinkForSignOut(driver);
	
	//result
	System.out.println("TEST CASE IS PASS");
}
}
