package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement OrganisationplusSign;
	
	@FindBy(name="accountname")
	private WebElement OrganisationName;
	
	@FindBy(id="phone")
	private WebElement OrganisationPhone;
	
	@FindBy(id="email1")
	private WebElement OrganisationEmail;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement OrganisationSave;

	public WebElement getOrganisationplusSign() {
		return OrganisationplusSign;
	}

	public WebElement getOrganisationName() {
		return OrganisationName;
	}

	public WebElement getOrganisationPhone() {
		return OrganisationPhone;
	}

	public WebElement getOrganisationEmail() {
		return OrganisationEmail;
	}
	
	public WebElement getOrganisationSave() {
		return OrganisationSave;
	}
	
	public void CreateOrganisation(String orgName, String orgPhone, String orgEmail)
	{
		OrganisationplusSign.click();
		OrganisationName.sendKeys(orgName);
		OrganisationPhone.sendKeys(orgPhone);
		OrganisationEmail.sendKeys(orgEmail);
		OrganisationSave.click();
	}

}
