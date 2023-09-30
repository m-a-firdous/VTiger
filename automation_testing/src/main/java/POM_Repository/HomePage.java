package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administerLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//getter method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getAdministerLink() {
		return administerLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	//business logic
	/**
	 * used to click on organization link
	 * @param driver
	 */
	public void clickOrganisationLink(WebDriver driver)
	{
		organizationLink.click();
	}
	
	/**
	 * used to click on product link
	 * @param driver
	 */
	public void clickProductLink(WebDriver driver)
	{
		productLink.click();
	}
	
	/**
	 * used to click on more link for campaign
	 * @param driver
	 */
	public void clickMoreLinkForCampaign(WebDriver driver)
	{
		moreLink.click();
		CampaignLink.click();
	}
	
	/**
	 * used to click on administer link for sign out
	 * @param driver
	 */
	public void clickAdministerLinkForSignOut(WebDriver driver)
	{
		administerLink.click();
		signOutLink.click();
	}
}
