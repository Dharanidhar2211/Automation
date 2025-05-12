package dharani.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dharani.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestComponents 

{
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver InitinilizeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\DHARANIDHAR\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\dharani\\resources\\GlobalData.properties");
		prop.load(fis);
		String BrowserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
		//String BrowserName=prop.getProperty("browser");
		if(BrowserName.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(BrowserName.contains("headless"))
			{
				options.addArguments("headless");
			}	
			driver =new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if (BrowserName.equalsIgnoreCase("fireFox"))
		{
			 driver=new FirefoxDriver();	
		}
		
		else if (BrowserName.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();	
		}
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
          driver.manage().window().maximize();
          return driver;
	}
	
	
	public List<HashMap<String, String>> GetJsonDataToMap(String filepath) throws IOException
	{
		
		// Reading json->String 
    	String jsoncontant=FileUtils.readFileToString(new File(filepath),
    			StandardCharsets.UTF_8);
    	
    	//String to hashMap-jackson databind
    	ObjectMapper mapper=new ObjectMapper();
    	List<HashMap<String ,String>> data=mapper.readValue(jsoncontant, new TypeReference<List<HashMap<String ,String>>>() {
		});
		
		return data;
	}
	
	
	
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage LaunchApplication() throws IOException
	{
		driver=InitinilizeDriver();
		 landingpage=new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void Close_Browser()
	{
		driver.close();
	}

	public String GetScreenShot(String TestCaseName,WebDriver driver) throws IOException 
	{
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//reports//"+TestCaseName+".png"));
		return System.getProperty("user.dir")+"//reports//"+TestCaseName+".png";
		
		
	}
}



