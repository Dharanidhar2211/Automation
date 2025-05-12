package dharani.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import dharani.AbstractComponents.AbstractComponents;

public class paymentpage extends AbstractComponents

{
	WebDriver driver;
	public paymentpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By w3=By.cssSelector(".ta-results");
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement contry;
	
	
	
	@FindBy(css=".action__submit")
	WebElement place;
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')]) [2]")
	WebElement in;
	
	@FindBy(css="hero-primary")
	WebElement w4;
	public successpage addcontry(String con)
	{
		Actions a=new Actions(driver);
		a.sendKeys(contry, con).build().perform();
		waitForElementToApper(w3);
		in.click();
		successpage su=new successpage(driver);
		return su;
	}
	public void clickonplaceorder() throws InterruptedException
	{
		place.click();
		waitForElementToDispper(w4);
	}
	
	

}
