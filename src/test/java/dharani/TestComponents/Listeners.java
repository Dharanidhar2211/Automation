package dharani.TestComponents;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dharani.resources.ExtentReporterNG;

public class Listeners extends BaseTestComponents implements ITestListener 
{
	ExtentReports extent=ExtentReporterNG.GetExtentReportContent();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "The complete test is Pass ");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "The complete test got fail at "+result.getMethod().getMethodName());
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		String FilePath = null;
		try {
			FilePath = GetScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(FilePath, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}
	@Override
	public void onStart(ITestContext context) {

	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
