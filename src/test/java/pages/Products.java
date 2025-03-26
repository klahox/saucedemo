package pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products {
	
	String buttonAddToCartBackPackID = "add-to-cart-sauce-labs-backpack";
	String buttonAddToCartBikeLightID = "add-to-cart-sauce-labs-bike-light";
	String buttonAddToCartFleeceJacketID = "add-to-cart-sauce-labs-fleece-jacket";					
	String buttonAddToCartOnesieID = "add-to-cart-sauce-labs-onesie";		
	
	String divPriceBackPackXPATH = "//button[@id='"+buttonAddToCartBackPackID+"']/preceding-sibling::*";
	String divPriceBikeLightXPATH = "//button[@id='"+buttonAddToCartBikeLightID+"']/preceding-sibling::*";
	String divPriceFleeceJacketXPATH = "//button[@id='"+buttonAddToCartFleeceJacketID+"']/preceding-sibling::*";
	String divPriceOnesieXPATH = "//button[@id='"+buttonAddToCartOnesieID+"']/preceding-sibling::*";
	
	String divCartID = "shopping_cart_container";
	
	WebDriver driver;
	
	public Products( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public Map<String, Float> savePricesAndAddToCart(){
		
		Map<String,Float> mapItemPrices= new HashMap<String, Float>();
		
		WebElement buttonAddToCartBackPack = driver.findElement(By.id(buttonAddToCartBackPackID));
		WebElement divPriceBackPack = buttonAddToCartBackPack.findElement(By.xpath(divPriceBackPackXPATH));
		float priceBackpack = Float.parseFloat(divPriceBackPack.getText().substring(1).trim());
		mapItemPrices.put("Backpack", priceBackpack);
		buttonAddToCartBackPack.click();
		
		
		WebElement buttonAddToCartBikeLight= driver.findElement(By.id(buttonAddToCartBikeLightID));
		WebElement divPriceBikeLight= buttonAddToCartBikeLight.findElement(By.xpath(divPriceBikeLightXPATH));
		float priceBikeLight= Float.parseFloat(divPriceBikeLight.getText().substring(1).trim());
		mapItemPrices.put("BikeLight", priceBikeLight);
		buttonAddToCartBikeLight.click();
		
		
		WebElement buttonAddToCartFleeceJacket= driver.findElement(By.id(buttonAddToCartFleeceJacketID));
		WebElement divPriceFleeceJacket = buttonAddToCartFleeceJacket.findElement(By.xpath(divPriceFleeceJacketXPATH));
		float priceFleeceJacket = Float.parseFloat(divPriceFleeceJacket.getText().substring(1).trim());
		mapItemPrices.put("FleeceJacket", priceFleeceJacket);
		buttonAddToCartFleeceJacket.click();
		
		
		WebElement buttonAddToCartOnesie = driver.findElement(By.id(buttonAddToCartOnesieID));
		WebElement divPriceOnesie= buttonAddToCartOnesie.findElement(By.xpath(divPriceOnesieXPATH));
		float priceOnesie = Float.parseFloat(divPriceOnesie.getText().substring(1).trim());
		mapItemPrices.put("Onesie", priceOnesie);
		buttonAddToCartOnesie.click();		
				
		System.out.println(mapItemPrices);
		
		
		WebElement divCart = driver.findElement(By.id(divCartID));		
		divCart.click();
		
		return mapItemPrices;
		
	}

}
