package withPOMandGeneric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import POM_Repository.HomePage;
import POM_Repository.LoginPage;
import POM_Repository.OrganizationPage;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation
{
	@Test
	public void CreateOrganisation() throws Throwable
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
	
	//random number
	int ranNum = ju.getRandomNumber();
	
	//credential
	String URL = fu.getCredentials("url");
	String USERNAME = fu.getCredentials("username");
	String PASSWORD = fu.getCredentials("password");
	driver.get(URL);
	
	//login
	LoginPage login = new LoginPage(driver);
	login.loginToVtiger(USERNAME, PASSWORD);
	
	//home
	HomePage home= new HomePage(driver);
	home.clickOrganisationLink(driver);
	
	//organisation
	OrganizationPage CreateOrganisation = new OrganizationPage(driver);
	
	//data
	String OrgName = eu.getExcelDataFromDataFormatter("Organisation", 0, 0)+ranNum;
	String OrgPhone = eu.getExcelDataFromDataFormatter("Organisation", 1, 0);
	String OrgEmail = eu.getExcelDataFromDataFormatter("Organisation", 2, 0);
	CreateOrganisation.CreateOrganisation(OrgName, OrgPhone, OrgEmail);
	
	//validation
	String Org = driver.findElement(By.className("dvHeaderText")).getText();
	if(Org.contains(OrgName))
	{
		System.out.println("PASS");
		System.out.println(Org);
		System.out.println("TEST CASE IS PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	
	//logout
	home.clickAdministerLinkForSignOut(driver);
	
	wu.windowClose(driver);
}

}
