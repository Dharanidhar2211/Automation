package dharani.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dharani.AbstractComponents.AbstractComponents;

public class successpage extends AbstractComponents
{
	WebDriver driver;
	public successpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement thankmessage;
	public String confirmsg()
	{
		String confirmMsg=thankmessage.getText();
		return confirmMsg;
	}
	
	

}
