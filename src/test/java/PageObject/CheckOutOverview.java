package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverview {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='cart_item']")
	private List<WebElement> productCount;
	
	@FindBy(xpath="//div[@class='cart_item']/descendant::div[@class='inventory_item_price']")
	private List<WebElement> price;
	
	@FindBy(xpath="//div[@class='summary_subtotal_label']")
	private WebElement itemTotal;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finish;
	
	public CheckOutOverview(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void calculateAmount() throws InterruptedException
	{
		int count = productCount.size();
		double amount =0;
		for(int i=0;i<count;i++)
		{
		   String s=price.get(i).getText();
		   s=s.replace("$","");
		   double c = Double.parseDouble(s);
		   
		   amount=amount+c;
		   
		   
		}
		String total=itemTotal.getText();
		total = total.replaceAll("[^.0-9]","");
		
		double t= Double.parseDouble(total);
		
		Thread.sleep(30);
		
		if(t==amount)
		{
			finish.click();
		}
		
	}
	
	
	
	

}
