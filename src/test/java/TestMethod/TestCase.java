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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.CardBag;
import PageObject.CheckOutInfo;
import PageObject.CheckOutOverview;
import PageObject.FinalPage;
import PageObject.LoginPage;
import PageObject.ProductPage;
import PageObject.YouCartPage;
import Utilities.RetryAnalyzer;
import io.github.bonigarcia.wdm.WebDriverManager;



public class TestCase {
	
    private ConfigReader reader;
    
    public WebDriver driver;
    
    @BeforeClass
	public void BrowserSetup()
	{
    	
    	ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);

        prefs.put("profile.credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);
        
        
 		
    	reader = new ConfigReader();
		String browserName = reader.getProperty("browser");

       
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
		String url = reader.getProperty("baseUrl");
		driver.get(url);
        //result.setAttribute("WebDriver", driver);

		driver.manage().window().maximize();
       // Reporter.getCurrentTestResult().setAttribute("driver", driver);

		
	}
    
    @BeforeMethod
    public void attachDriverToListener(ITestResult result) {
        // Set driver for each test execution
        result.setAttribute("driver", driver);
    }
    
    @Test(priority=1,retryAnalyzer = RetryAnalyzer.class)
    public void LoginPage1()
    {
    	
    	LoginPage login=new LoginPage(driver);
    	String username =reader.getProperty("username");
    	String password= reader.getProperty("password");
    	login.userName(username);
    	login.PasswordWord(password);
    	login.loginSend();
    	//login.wait1();
    	
    }
    
    @Test(priority=2,retryAnalyzer = RetryAnalyzer.class)
    public void ProductPageOperation() throws InterruptedException
    {
    	ProductPage p=new ProductPage(driver);
    	p.productSelect();
    	CardBag c1=new CardBag(driver);

    	c1.checkaddToCount();
    }
    
    
    @Test(priority=3,retryAnalyzer = RetryAnalyzer.class)
    public void Cardchecks() throws InterruptedException
    {
    	YouCartPage p1=new YouCartPage(driver);
    	p1.scroll();
    	p1.CheckOut();
    }
    
    @Test(priority=4,retryAnalyzer = RetryAnalyzer.class)
    public void info() throws InterruptedException
    {
    	CheckOutInfo c= new CheckOutInfo(driver);
    	c.information("bhuvana","p","602026");
    	c.submit();
    	
    }
    
    @Test(priority=5,retryAnalyzer = RetryAnalyzer.class)
    public void infoOverview() throws InterruptedException
    {
    	CheckOutOverview c= new CheckOutOverview(driver);
    	c.calculateAmount();
    	
    }
    
    
    @Test(priority=6,retryAnalyzer = RetryAnalyzer.class)
    public void card()
    {
    	FinalPage f= new FinalPage(driver);
    	f.finalstep();
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
