package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.File_Utility;

public class Ex
{
	public static void main(String args[]) throws Throwable
	{
		File_Utility fu = new File_Utility();
		WebDriver driver=new ChromeDriver();
		
		//credential
		String URL = fu.getCredentials("url");
		String USERNAME = fu.getCredentials("username");
		String PASSWORD = fu.getCredentials("password");
		driver.get(URL);
		WebElement un = driver.findElement(By.name("user_name"));
		WebElement pw = driver.findElement(By.name("user_password"));
		WebElement lg = driver.findElement(By.id("submitButton"));
		
		un.sendKeys(USERNAME);
		pw.sendKeys(PASSWORD);
		lg.click();
	}
}
