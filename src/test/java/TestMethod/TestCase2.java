package TestMethod;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TestCase2 {
	
	WebDriver driver;
	
	  @Test
	  public void LoginPage1()
	  {
		  LoginPage login=new LoginPage(driver);

			
			login.userName("bhuvana");
	    	login.PasswordWord("123");
	    	login.loginSend();
	  }

}
