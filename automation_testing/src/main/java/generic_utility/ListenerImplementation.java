package generic_utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

@SuppressWarnings("deprecation")
public class ListenerImplementation implements ITestListener 
{
	public void onTestFailure(ITestResult result)
	{
		String Testdata = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(Base_Class.Sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ScreenShot/"+Testdata+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
