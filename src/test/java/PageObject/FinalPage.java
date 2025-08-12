package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinalPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
	private WebElement content;
	
	@FindBy(xpath="//button[contains(text(),'Back Home')]")
	private WebElement back_home;
	
	public FinalPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void finalstep()
	{
		String content1=content.getText();
		if(content1.equals("Thank you for your order!"))
		{
			back_home.click();
		}
	}
	

}
