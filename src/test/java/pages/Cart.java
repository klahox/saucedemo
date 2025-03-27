package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
	
	String divItemXPATH= "//div[@data-test='inventory-item']";
	String divNameXPath =".//div[@data-test='inventory-item-name']";
	String divPriceXPath =".//div[@data-test='inventory-item-price']";
	
	private static final Logger logger = LogManager.getLogger(Cart.class);
	
	String buttonCheckoutID ="checkout";
	
	WebDriver driver;
	
	public Cart( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public void checkOut() {
		
		WebElement buttonCheckout = driver.findElement(By.id(buttonCheckoutID));
		buttonCheckout.click();
		logger.info("Clicking on button checkout");
	}
	
	
	public boolean checkThatNameAndPricesAreCorrect(JSONObject jsonNamePrice) {
		
		List<WebElement> listItems = driver.findElements(By.xpath(divItemXPATH));
		
		for(WebElement item: listItems){
			
			WebElement divName = item.findElement(By.xpath(divNameXPath));
			String name = divName.getText();
			
			WebElement divPrice = item.findElement(By.xpath(divPriceXPath));
			float price = Float.parseFloat(divPrice.getText().split("\\$")[1].trim());
					
			if((float)jsonNamePrice.get(name) != price) {
				
				return false;
			}
			
			logger.info("Checking that Name and Price are correct '{}' with this price '{}'",name,price);

		}
		
		return true;
		
	}
	
	
	
	
	
	
	
	

}
