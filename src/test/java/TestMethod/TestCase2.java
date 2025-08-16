package TestMethod;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import Utilities.RetryAnalyzer;

public class TestCase2 {
	
	WebDriver driver;
	
	  @Test(retryAnalyzer = RetryAnalyzer.class)
	  public void LoginPage1()
	  {
		  LoginPage login=new LoginPage(driver);

			
			login.userName("bhuvana");
	    	login.PasswordWord("123");
	    	login.loginSend();
	  }

}
