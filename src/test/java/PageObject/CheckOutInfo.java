package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfo {

	private WebDriver driver;
	
	@FindBy(id="first-name")
	private WebElement first_name;
	
	
	@FindBy(id="last-name")
	private WebElement last_name;
	
	@FindBy(id="postal-code")
	private WebElement postal_code;
	
	@FindBy(id="continue")
	private WebElement Continue;
	
	public CheckOutInfo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void information(String firstname, String lastname, String code)
	{
		first_name.sendKeys(firstname);
		last_name.sendKeys(lastname);
		postal_code.sendKeys(code);
	}
	public void submit() throws InterruptedException
	{
		Continue.click();
		Thread.sleep(3000);
	}
	
	
}
