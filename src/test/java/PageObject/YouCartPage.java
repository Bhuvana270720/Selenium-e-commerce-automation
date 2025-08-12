package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouCartPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")
	private WebElement checkOut;
	
	public YouCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void scroll() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true)",checkOut);
	    Thread.sleep(3000);
	}
	public void CheckOut() throws InterruptedException
	{
		checkOut.click();
		Thread.sleep(3000);
	}

}
