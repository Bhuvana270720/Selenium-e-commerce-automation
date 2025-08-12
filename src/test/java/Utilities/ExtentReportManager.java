package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;  //ui
	public ExtentReports extent;  //common information
	public ExtentTest test; // status update
	
	
	public void onStart(ITestContext context) {
         
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/myReport.html");
		
		sparkreporter.config().setDocumentTitle("Automated Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		extent.setSystemInfo("Computer","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester","Bhuvana");
		extent.setSystemInfo("Os","windows10");
		extent.setSystemInfo("Browser","Chrome");

	}
	public void onTestStart(ITestResult result) {
		 test = extent.createTest(result.getName());
	     WebDriver driver = (WebDriver) result.getAttribute("driver");

		 if(driver!=null)
		 {
			 try {
				String screenshot = ScreenshotUtilits.captureScreenshot(driver, result.getMethod().getMethodName()+ "_pass");
				test.addScreenCaptureFromPath(screenshot, "Screenshot on Success");
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 
			 
		 }
		 test.log(Status.PASS, "Test case passed is" + result.getName());
		
	  }
	
	public void onTestFailure(ITestResult result) {
		 test = extent.createTest(result.getName());
		 WebDriver driver = (WebDriver) result.getAttribute("driver");
		 if(driver!=null)
		 {
			 try {
				String screenshot = ScreenshotUtilits.captureScreenshot(driver, result.getMethod().getMethodName()+ "_Failed");
				test.addScreenCaptureFromPath(screenshot, "Screenshot on Failure");
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 
			 
		 }
		 test.log(Status.FAIL, "Test case Failed is" + result.getName());
		 test.log(Status.FAIL, "Test case Failed cause is" + result.getThrowable());
		
	  }
	public void onTestSkipped(ITestResult result) {
		 test = extent.createTest(result.getName());
		 test.log(Status.SKIP, "Test case Skipped is" + result.getName());
		
	  }
	
	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

	

}
