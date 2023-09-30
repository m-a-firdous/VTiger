package POM_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class login1 
{
	//initialization
		public login1(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//declaration
		@FindBy(name="user_name")
		private WebElement userTextField;
		
		@FindBys({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
		private WebElement passwordTextField;
		
		@FindAll({@FindBy(xpath="//input[@type='submit']"),@FindBy(id="submitButton")})
		private WebElement submitButton;

		public WebElement getUserTextField() {
			return userTextField;
		}

		public WebElement getPasswordTextField() {
			return passwordTextField;
		}

		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		public void Login(String Username,String Password)
		{
			userTextField.sendKeys(Username);
			passwordTextField.sendKeys(Password);
			submitButton.click();
			
		}

}
