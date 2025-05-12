package dharani.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dharani.AbstractComponents.AbstractComponents;

public class cartpage extends AbstractComponents
{

	WebDriver driver;
	public cartpage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	public boolean cartitems(String item)
	{
		boolean b=cproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(item));
		return b;
		
	}
	public paymentpage clickoncheckout()
	{
		checkout.click();
		paymentpage pay=new paymentpage(driver);
		return pay;
		
	}
	
}
