package dharani.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dharani.TestComponents.BaseTestComponents;
import dharani.pageObjects.LandingPage;
import dharani.pageObjects.cartpage;
import dharani.pageObjects.paymentpage;
import dharani.pageObjects.productsCatlog;
import dharani.pageObjects.successpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinitionImplementation extends BaseTestComponents
{
	public LandingPage landingpage;
	public productsCatlog productcatlog;
	public cartpage cart;
	public paymentpage pay;
	public successpage su;
	@Given("I landed on Ecommerce page")
	public void I_Landed_on_Ecommerce_Page() throws IOException
	{
		landingpage =LaunchApplication();
	}
	
	@Given("^Logged in with valid username(.+) and password (.+)$")
	public void Logged_in_with_Valid_Email_and_password(String email,String password )
	{
		 productcatlog=landingpage.loginapplication(email, password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_Addproduct_toCart(String item) throws InterruptedException
	{
		List<WebElement> products=productcatlog.getProductsList();
		cart=productcatlog.addProductToCart(item);
		
	}
	
	@And("^Checkout the item(.+) and submit the order$") 
	public void Checkout_the_Item_and_Submit_the_Order(String item) throws InterruptedException
	{
		productcatlog.clickOnCart();
		boolean b=cart.cartitems(item);
		Assert.assertTrue(b);
		pay=cart.clickoncheckout();
		su=pay.addcontry("India");
		pay.clickonplaceorder();
	}
	@Then("{string} is Displayed on confirmation page")
	public void message_Displayed_ConfirmationPage(String string)
	{
		String msg=su.confirmsg();
		Assert.assertTrue(msg.equalsIgnoreCase(string));
		driver.close();
	}
	@Then("{string} message is  Displayed")
	public void Errormessage_is_Displayed(String string1)
	{
		Assert.assertEquals(string1, landingpage.Errorpop());
		driver.close();
	}
	
}
