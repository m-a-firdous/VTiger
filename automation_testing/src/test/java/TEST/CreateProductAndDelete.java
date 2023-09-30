package TEST;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import POM_Repository.HomePage;
import POM_Repository.ProductDelete;
import POM_Repository.ProductPage;
import generic_utility.Base_Class;
import generic_utility.Excel_Utility;
import generic_utility.File_Utility;
import generic_utility.Java_Utility;
import generic_utility.WebDriver_Utility;

public class CreateProductAndDelete extends Base_Class
{
	@Test(groups = "smokeTest")
	public void CreateProductAnddelete() throws Throwable
{
	//utilities
	Excel_Utility eu = new Excel_Utility();
	File_Utility fu = new File_Utility();
	Java_Utility ju = new Java_Utility();
	WebDriver_Utility wu = new WebDriver_Utility();//implicit wait
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
	
	//delete product
	ProductDelete delete = new ProductDelete(driver);
	delete.DeleteProduct(driver, ProdName, wu);
	
	List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
	boolean flag=false;
	for(WebElement ProductName:productList)
	{
		String actData = ProductName.getText();
		if(actData.contains(ProdName))
		{
			flag=true;
			break;
		}
	}
	if(flag)
	{
		System.out.println("Product is deleted");
		System.out.println("TEST CASE IS PASS");
	}
	else
	{
		System.out.println("Product is not deleted");
	}
}
}
