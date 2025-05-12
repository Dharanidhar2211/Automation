package dharani.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dharani.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	@FindBy(css="#userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(xpath = "//input[contains(@type,'submit')]")
	WebElement submit;
	
	
	
	
	@FindBy(css = ".toast-message")
	WebElement errorPopup;
	
	public productsCatlog loginapplication(String mail,String passWord)
	{
		email.sendKeys(mail);
		
		password.sendKeys(passWord);
		
		submit.click();
		productsCatlog productcatlog=new productsCatlog(driver);
		return productcatlog;
		
	}
	
	public String Errorpop()
	{
		waitForWebElementToApper(errorPopup);
		return errorPopup.getText();
		 
	}
	
	
}
