package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation
{
	//initialization
	public Validation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement CampValidation;

	@FindBy(className="dvHeaderText")
	private WebElement orgValidation;
	
	@FindBy(className="dvtCellInfo")
	private WebElement prodValidation;

	public WebElement getCampValidation() {
		return CampValidation;
	}

	public WebElement getOrgValidation() {
		return orgValidation;
	}

	public WebElement getProdValidation() {
		return prodValidation;
	}
	
	//business logic
	public String campValidation()
	{
		return CampValidation.getText();	
	}
	
	public String orgValidation()
	{
		return orgValidation.getText();	
	}
	
	public String prodValidation()
	{
		return prodValidation.getText();	
	}
}
