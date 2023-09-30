package TEST;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Repository.HomePage;
import POM_Repository.ProductPage;
import POM_Repository.Validation;
import generic_utility.Base_Class;

public class CreateProduct extends Base_Class
{
	@Test(groups = "regressionTest")
	public void CreateProduct() throws Throwable
{
	//implicit wait
	wu.ImplicitWait(driver);
	
	//maximize
	wu.windowMaximize(driver);
	
	//random number
	int ranNum = ju.getRandomNumber();
	
	//product
	HomePage home = new HomePage(driver);
	home.clickProductLink(driver);
	
	//create product
	ProductPage CreateProduct= new ProductPage(driver);
	String ProdName = eu.getExcelDataFromDataFormatter("Product", 0, 0)+ranNum;
	CreateProduct.CreateProduct(driver, ProdName);
	
	//validation
	Validation valid = new Validation(driver);
	String prod = valid.prodValidation();
	Assert.assertEquals(ProdName, prod);
	/*String Prod = driver.findElement(By.className("dvtCellInfo")).getText();
	if(Prod.contains(ProdName))
	{
		System.out.println("PASS");
		System.out.println(Prod);
		System.out.println("TEST CASE IS PASS");
	}
	else
	{
		System.out.println("FAIL");
	}*/
}
}
