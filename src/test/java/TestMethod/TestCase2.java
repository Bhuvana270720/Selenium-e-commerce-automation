package TestMethod;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utilities.RetryAnalyzer;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {
	
	WebDriver driver;
	
	 @BeforeClass
		public void BrowserSetup()
		{
	    	
	    	ChromeOptions options = new ChromeOptions();

	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.password_manager_leak_detection", false);

	        prefs.put("profile.credentials_enable_service", false);

	        options.setExperimentalOption("prefs", prefs);
	        
	        
			String browserName = "chrome";

	       
			if(browserName.equals("chrome"))
			{
				
				WebDriverManager.chromedriver().setup();
				
				driver = new ChromeDriver(options);

			}
			else if(browserName.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}
			driver.get("https://www.saucedemo.com/");
	        //result.setAttribute("WebDriver", driver);

			driver.manage().window().maximize();
	       // Reporter.getCurrentTestResult().setAttribute("driver", driver);

			
		}
	    
	    @BeforeMethod
	    public void attachDriverToListener(ITestResult result) {
	        // Set driver for each test execution
	        result.setAttribute("driver", driver);
	    }
	    
	
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  public void LoginPage1()
	  {
		  LoginPage login=new LoginPage(driver);

			
			login.userName("bhuvana");
	    	login.PasswordWord("123");
	    	login.loginSend();
	  }
	  
	  @AfterClass
		public void teardown()
		{
			if(driver!=null)
			{
				driver.quit();
			}
		}
	    

}
