package dataProvider;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_Repository.CampaignPage;
import POM_Repository.HomePage;
import generic_utility.Base_Class;

public class VtigerCamp extends Base_Class
{
	@Test(dataProvider="getData")
	public void vTiger(String CampName)
	{	
		//campaign link
		HomePage home = new HomePage(driver);
		home.clickMoreLinkForCampaign(driver);
		
		CampaignPage Createcamp = new CampaignPage(driver);
		Createcamp.CreateCamp(CampName);
		
		//validation
		String camp = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if(camp.contains(CampName))
		{
			System.out.println("PASS");
			System.out.println(camp);
		}
		else
		{
			System.out.println("FAIL");
		}
			
	}
	@DataProvider
	public Object[][] getData()
	{
	Random ran = new Random();
	int ranNum=ran.nextInt(1000);
	Object[][] data = new Object[3][1];
	
	data[0][0]="Bangalore"+ranNum;
	
	data[1][0]="hyderabad"+ranNum;
	
	data[2][0]="mumbai"+ranNum;
	
	return data;
	}
}
