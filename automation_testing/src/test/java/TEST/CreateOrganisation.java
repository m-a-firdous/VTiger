package TEST;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repository.HomePage;
import POM_Repository.LoginPage;
import POM_Repository.OrganizationPage;
import POM_Repository.Validation;
import generic_utility.Base_Class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

public class CreateOrganisation extends Base_Class
{
	@Test(groups = {"smokeTest", "regressionTest"})
	public void CreateOrganisation() throws Throwable
	{	
		//random number
		int ranNum = ju.getRandomNumber();
		
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
		Validation valid = new Validation(driver);
		String org = valid.orgValidation();
		Assert.assertEquals(OrgName, org);
		/*String Org = driver.findElement(By.className("dvHeaderText")).getText();
		if(Org.contains(OrgName))
		{
			System.out.println("PASS");
			System.out.println(Org);
			System.out.println("TEST CASE IS PASS");
		}
		else
		{
			System.out.println("FAIL");
		}*/

	}

}
