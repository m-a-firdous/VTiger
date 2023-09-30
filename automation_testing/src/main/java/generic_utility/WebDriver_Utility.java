package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility
{
	/**
	 * this is used to maximize the window
	 * @param driver
	 * @author Tayyaba
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this is used to minimize the window
	 * @param driver
	 * @author Tayyaba
	 */
	public void windowMinimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * this is used to window full screen
	 */
	public void windowFullScreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * this is used to close window
	 * @param driver
	 * @author Tayyaba
	 */
	public void windowClose(WebDriver driver)
	{
		driver.close();
	}
	
	/**
	 * this is used for implicit wait
	 * @param driver
	 * @author Tayyaba
	 */
	public void ImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * this is used for switching window
	 * @param driver
	 * @param VisibleText
	 * @author Tayyaba
	 */
	public void windowSwitching(WebDriver driver, String VisibleText)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while(id.hasNext())
		{
			String window = id.next();
			driver.switchTo().window(window);
			String title = driver.getTitle();
			
			if(title.contains(VisibleText))
			{
				break;
			}
		}
	}
	
	/**
	 * it is used to scroll the window
	 * @param driver
	 * @param element
	 * @author Tayyaba
	 */
	public void Windowscrolling(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * it is used to accept the alertpop up
	 * @param driver
	 * @author Tayyaba
	 */
	public void alertAceeptPopUp(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	/**
	 * it is used to dismiss the alert pop up
	 * @param driver
	 */
	public void alertDismisstPopUp(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	/**
	 * it is used to move to the element
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
}

