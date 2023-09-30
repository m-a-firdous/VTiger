package TEST;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import POM_Repository.CampaignPage;
import POM_Repository.HomePage;
import POM_Repository.ProductPage;
import POM_Repository.ProductWindowInCampaign;
import generic_utility.Base_Class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

public class CreateCampaignWithProduct extends Base_Class
{
	@Test(groups = "smokeTest")
	public void CreateCampaignWithProduct() throws Throwable
	{	
		//random number
		int ranNum = ju.getRandomNumber();
		
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
		ProdCamp.SelectProduct(driver, ProdName, wu);
		
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
	

}
