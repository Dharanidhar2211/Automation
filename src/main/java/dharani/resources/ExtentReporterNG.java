package dharani.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	public static ExtentReports GetExtentReportContent()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\Results.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Results");
		reporter.config().setReportName("Purchase Order TestResults");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester Name ", "Dharanidhar");
		extent.setSystemInfo("Platform", "Android");
		extent.createTest("Results");
		return extent;
	}

}
