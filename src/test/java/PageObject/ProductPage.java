package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//div[@class='inventory_item']")
	private List<WebElement> productElement; 
	
	@FindBy(xpath="//div[@class='inventory_item']/descendant::div[@class='inventory_item_description']/descendant::div[@class='pricebar']/descendant::div[@class='inventory_item_price']")
	private List<WebElement> price;
	
	@FindBy(xpath="//div[@class='inventory_item']/descendant::div[@class='inventory_item_description']/descendant::div[@class='pricebar']/descendant::div[@class='inventory_item_price']/following-sibling::button[contains(text(),'Add to cart')]")
	private List<WebElement> AddCart;
	
	
	
	public static int productselectCount=0;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void productSelect() throws InterruptedException
	{
		int productCount= productElement.size();
		for(int i=0;i<productCount;i++)
		{
			String productPrice = price.get(i).getText();

			productPrice = productPrice.replace("$","");
			double prices = Double.parseDouble(productPrice);
			
			if(prices >= 1 && prices <= 16)
			{
				AddCart.get(i-productselectCount).click();
				productselectCount++;

			  /* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			   wait.until(ExpectedConditions.textToBePresentInElement(AddCart.get(i),"Remove"));
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			   String AddCardValue= AddCart.get(i).getText();
			
			if(AddCardValue.equals("Remove"))
			{
				System.out.println("added");
			}*/
			
			}
			
		}
		Thread.sleep(3000);
	
	}
	
	
	
	
	

}
