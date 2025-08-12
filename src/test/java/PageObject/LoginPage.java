package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
private WebDriver driver;
	
	@FindBy(id="user-name")
	private WebElement User_Name;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(id="login-button")
	private WebElement login_btn;
	
	@FindBy(xpath="//div[contains(text(),'Swag Labs')]")
	private  WebElement pageload;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public WebElement getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(WebElement user_Name) {
		User_Name = user_Name;
	}

	public WebElement getPassword() {
		return Password;
	}

	public void setPassword(WebElement password) {
		Password = password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}

	public void setLogin_btn(WebElement login_btn) {
		this.login_btn = login_btn;
	}

	public WebElement getPageload() {
		return pageload;
	}

	public void setPageload(WebElement pageload) {
		this.pageload = pageload;
	}
	
	public void userName(String name)
	{
		User_Name.sendKeys(name);
	}
	
	public void PasswordWord(String word)
	{
		Password.sendKeys(word);
	}
	
	public void loginSend()
	{
		login_btn.click();
	}
	
	public void wait1()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// Wait for the pop-up container
    	WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
    	    By.xpath("//div[contains(text(),'Change your password')]")
    	));

    	// Click the OK button inside the pop-up
    	popup.findElement(By.xpath(".//button[text()='OK']")).click();
	}
	
	


	
	

}
