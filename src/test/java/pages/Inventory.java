package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory {
	
	private static final Logger logger = LogManager.getLogger(Inventory.class);
	
	String[] ids = {"add-to-cart-sauce-labs-backpack", 
	                "add-to-cart-sauce-labs-bike-light",
	                "add-to-cart-sauce-labs-fleece-jacket",					
					"add-to-cart-sauce-labs-onesie"};

	String divCartID = "shopping_cart_container";
	
	WebDriver driver;
	
	public Inventory( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public JSONObject savePricesAndAddToCart(){
		
		JSONObject jsonNamePrice = new JSONObject();
		
		for(String id: this.ids){
			
			// Getting item Price
			String divPriceXPATH = "//button[@id='"+id+"']/preceding-sibling::*";
			WebElement divPrice = driver.findElement(By.xpath(divPriceXPATH));
			float itemPrice = Float.parseFloat(divPrice.getText().substring(1).trim());
			
			// Getting item Name
			String divNameXPATH = "//button[@id='"+id+"']/parent::div//preceding-sibling::div//div[@data-test='inventory-item-name']";
			WebElement divName = driver.findElement(By.xpath(divNameXPATH));
			String itemName = divName.getText().trim();
			
			jsonNamePrice.put(itemName, itemPrice);
			
			//Adding into the cart
			WebElement buttonAddToCartBackPack = driver.findElement(By.id(id));
			buttonAddToCartBackPack.click();
			logger.info("Adding into the cart this product '{}' with this price '{}'",itemName,itemPrice);
			
		}
		
		logger.info("Showing cart data {}",jsonNamePrice);
		
		WebElement divCart = driver.findElement(By.id(divCartID));		
		divCart.click();
		
		return jsonNamePrice;
		
	}

}
