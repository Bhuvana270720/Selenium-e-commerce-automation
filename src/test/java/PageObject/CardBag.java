package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardBag {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[@id='shopping_cart_container']/descendant::a//span[@class='shopping_cart_badge']")
	private WebElement cart;
	
	public CardBag(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkaddToCount() throws InterruptedException
	{
		
		
		int c=Integer.parseInt(cart.getText());
		
		if(c==ProductPage.productselectCount)
		{
			System.out.println("all card added successfully");
			cart.click();
			Thread.sleep(3000);
		}
		
	}

}
