package dharani.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import dharani.TestComponents.BaseTestComponents;
import dharani.pageObjects.LandingPage;
import dharani.pageObjects.OrderPage;
import dharani.pageObjects.cartpage;
import dharani.pageObjects.paymentpage;
import dharani.pageObjects.productsCatlog;
import dharani.pageObjects.successpage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class StandAloneTest extends BaseTestComponents{

	
	@Test(dataProvider = "GetData",groups = "Purchase")
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException

	{
		
		productsCatlog productcatlog=landingpage.loginapplication(input.get("email"), input.get("Password"));
		List<WebElement> products=productcatlog.getProductsList();
		cartpage cart=productcatlog.addProductToCart(input.get("item"));
		productcatlog.clickOnCart();
		boolean b=cart.cartitems(input.get("item"));
		Assert.assertTrue(b);
		paymentpage pay=cart.clickoncheckout();
		successpage su=pay.addcontry("India");
		pay.clickonplaceorder();
		String msg=su.confirmsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
 
	}
	@Test(dependsOnMethods = {"SubmitOrder"},dataProvider = "GetData")
	public void OrderHistoryTest(HashMap<String, String> input)
	{
		
		productsCatlog productcatlog=landingpage.loginapplication(input.get("email"), input.get("Password"));
		OrderPage orderpage=productcatlog.goToOrderPage();
		boolean b=orderpage.verifyOrderspageDispayed(input.get("item"));
		Assert.assertTrue(b);
		
		
	}
	
	@DataProvider
	public Object[][] GetData() throws IOException
	{
	
		List<HashMap<String, String >> data=GetJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\dharani\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	
	
}

	
