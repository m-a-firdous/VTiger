package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProdPlusSign;
	
	@FindBy(name="productname")
	private WebElement ProductName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement ProdSaveButton;

	public WebElement getCreateProdPlusSign() {
		return CreateProdPlusSign;
	}

	public WebElement getProductName() {
		return ProductName;
	}

	public WebElement getProdSaveButton() {
		return ProdSaveButton;
	}
	
	public void CreateProduct(WebDriver driver, String ProdName)
	{
		CreateProdPlusSign.click();
		ProductName.sendKeys(ProdName);
		ProdSaveButton.click();
	}

}
