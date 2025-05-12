package dharani.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dharani.AbstractComponents.AbstractComponents;

public class productsCatlog extends AbstractComponents
{

	
	WebDriver driver;
	public productsCatlog(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By productsby=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.xpath("//div[text()=' Product Added To Cart ']");
	
	public List<WebElement> getProductsList()
	{
		waitForElementToApper(productsby);
		return products;
	}
	
	public WebElement getProductName(String item)
	{
		WebElement prod=getProductsList().stream().filter(s->s.findElement(By.tagName("b")).getText().equals(item)).findFirst().orElse(null);
		return prod;
	}
	public cartpage addProductToCart(String item) throws InterruptedException
	{
		WebElement prod=getProductName(item);
		prod.findElement(addToCart).click();
		waitForElementToApper(toastmessage);
		waitForElementToDispper(spinner);
		cartpage cart=new cartpage(driver);
		return cart;
	}
	
	
	
	
	
}
