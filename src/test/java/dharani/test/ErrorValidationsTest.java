 	package dharani.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import dharani.TestComponents.BaseTestComponents;
import dharani.TestComponents.retry;
import dharani.pageObjects.cartpage;
import dharani.pageObjects.paymentpage;
import dharani.pageObjects.productsCatlog;
import dharani.pageObjects.successpage;
public class ErrorValidationsTest extends BaseTestComponents{

	@Test(groups = {"Error"},retryAnalyzer = retry.class )
	public void LoginErrorValidation() throws IOException, InterruptedException

	{
		String item="ADIDAS ORIGINAL";
		String con="India";
		productsCatlog productcatlog=landingpage.loginapplication("dharanidhar220@gmail.com", "aIlovecricket@1234");
		Assert.assertEquals("Incorrect email or password.", landingpage.Errorpop());
	 
	}

	@Test
	public void ProductErrorValation() throws IOException, InterruptedException

	{
		String item="ADIDAS ORIGINAL";
		String con="India";
		productsCatlog productcatlog=landingpage.loginapplication("dharanidhar2211@gmail.com", "Ilovecricket@123");
		List<WebElement> products=productcatlog.getProductsList();
		cartpage cart=productcatlog.addProductToCart(item);
		productcatlog.clickOnCart();
		boolean b=cart.cartitems("ADIDAS ORIGINAL 1");
		Assert.assertFalse(b);
		
	}
	
}

	
