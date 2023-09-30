package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Empty_Browser {

	public static void main(String[] args)
	{
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}

}
