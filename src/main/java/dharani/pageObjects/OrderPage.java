package dharani.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dharani.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents
{

	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> orderproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	public boolean verifyOrderspageDispayed(String item)
	{
		boolean b=orderproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return b;
		
	}
	

	
}
