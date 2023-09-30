package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage
{
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement CreateCampPlusSign;
	
	@FindBy(name="campaignname")
	private WebElement CampName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement CampSaveButton;

	public WebElement getCreateCampPlusSign() {
		return CreateCampPlusSign;
	}

	public WebElement getCampName() {
		return CampName;
	}

	public WebElement getCampSaveButton() {
		return CampSaveButton;
	}
	
	public void CreateCamp(String CampaignName)
	{
		CreateCampPlusSign.click();
		CampName.sendKeys(CampaignName);
		CampSaveButton.click();
	}
	
	
}
