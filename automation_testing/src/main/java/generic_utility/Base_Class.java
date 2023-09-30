package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import POM_Repository.HomePage;
import POM_Repository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class
{
public static WebDriver driver;
public static WebDriver Sdriver;
public WebDriver_Utility wu = new WebDriver_Utility();
public File_Utility fu = new File_Utility();
public Excel_Utility eu = new Excel_Utility();
public Java_Utility ju = new Java_Utility();

	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void beforeSuite()
	{
		System.out.println("Data base connection");
	}
	
	@BeforeTest(groups = {"smokeTest", "regressionTest"})
	public void beforeTest()
	{
		System.out.println("Parallel execution");
	}
	
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void beforeClass() throws Throwable
	{
		String BROWSER = fu.getCredentials("browser");
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
		driver.manage().window().maximize();
		wu.ImplicitWait(driver);
		System.out.println("Launching Browser");
	}
	
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void beforeMethod() throws Throwable
	{
		String URL = fu.getCredentials("url");
		String USERNAME = fu.getCredentials("username");
		String PASSWORD = fu.getCredentials("password");
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToVtiger(USERNAME, PASSWORD);
		System.out.println("Login to application");
	}
	
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void afterMethod()
	{
		HomePage home= new HomePage(driver);
		home.clickAdministerLinkForSignOut(driver);
		System.out.println("Logout from application");
	}
	
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("Close Browser");
	}
	
	@AfterTest(groups = {"smokeTest", "regressionTest"})
	public void afterTest()
	{
		System.out.println("Parallel execution done");
	}
	
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void afterSuite()
	{
		System.out.println("Data base connection close");
	}

}
