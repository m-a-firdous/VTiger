package TEST;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repository.CampaignPage;
import POM_Repository.HomePage;
import POM_Repository.Validation;
import generic_utility.Base_Class;

public class CreateCampaign extends Base_Class
{
	@Test(retryAnalyzer = generic_utility.RetryImplementation.class)
	public void CreateCampaign() throws Throwable
	{		
		//random number
		int ranNum = ju.getRandomNumber();
		
		//campaign link
		HomePage home = new HomePage(driver);
		home.clickMoreLinkForCampaign(driver);
		
		//campaign page
		CampaignPage Createcamp = new CampaignPage(driver);
		String CampName = eu.getExcelData("Campaign", 0, 0)+ranNum;
		Createcamp.CreateCamp(CampName);
		
		//validation
		Validation valid = new Validation(driver);
		String camp = valid.campValidation();
		Assert.assertEquals(CampName, camp);
		
		/*String camp = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if(camp.contains(CampName))
		{
			System.out.println("PASS");
			System.out.println(camp);
		}
		else
		{
			System.out.println("FAIL");
		}*/
	}

}
