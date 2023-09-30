package POM_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.WebDriver_Utility;

public class ProductDelete
{
	public ProductDelete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteButton;

	public WebElement getProductLink() {
		return ProductLink;
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
	
	//business logic
	public void DeleteProduct(WebDriver driver, String ProdName, WebDriver_Utility wu)
	{
		ProductLink.click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProdName+"']/../preceding-sibling::td/input")).click();
		DeleteButton.click();
		wu.alertAceeptPopUp(driver);
	}

}
