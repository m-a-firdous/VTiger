package POM_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriver_Utility;

public class ProductWindowInCampaign
{
	public ProductWindowInCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement ProductSelect;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement SearchTextBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchButton;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getProductSelect() {
		return ProductSelect;
	}

	public WebElement getSearchTextBox() {
		return SearchTextBox;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	//business logic
	public void Product(WebDriver driver,String ProdName,WebDriver_Utility wu)
	{
		ProductSelect.click();
		wu.windowSwitching(driver, "Products&actions");
		SearchTextBox.sendKeys(ProdName);
		SearchButton.click();
	}
	
	public void SelectProduct(WebDriver driver, String ProdName, WebDriver_Utility wu)
	{
		driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
		wu.windowSwitching(driver, "Campaigns&action");
		SaveButton.click();
	}

}
