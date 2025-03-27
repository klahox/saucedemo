package pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.SaurceDemoE2ESeleniumTestNG;

public class Products {
	
	private static final Logger logger = LogManager.getLogger(Products.class);
	
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
		mapItemPrices.put(buttonAddToCartBackPackID, priceBackpack);
		buttonAddToCartBackPack.click();
		logger.info("Adding into the cart this product {} with this price {}",buttonAddToCartBackPackID,priceBackpack);
		
		
		WebElement buttonAddToCartBikeLight= driver.findElement(By.id(buttonAddToCartBikeLightID));
		WebElement divPriceBikeLight= buttonAddToCartBikeLight.findElement(By.xpath(divPriceBikeLightXPATH));
		float priceBikeLight= Float.parseFloat(divPriceBikeLight.getText().substring(1).trim());
		mapItemPrices.put(buttonAddToCartBikeLightID, priceBikeLight);
		buttonAddToCartBikeLight.click();
		logger.info("Adding into the cart this product {} with this price {}",buttonAddToCartBikeLightID,priceBikeLight);
		
		
		WebElement buttonAddToCartFleeceJacket= driver.findElement(By.id(buttonAddToCartFleeceJacketID));
		WebElement divPriceFleeceJacket = buttonAddToCartFleeceJacket.findElement(By.xpath(divPriceFleeceJacketXPATH));
		float priceFleeceJacket = Float.parseFloat(divPriceFleeceJacket.getText().substring(1).trim());
		mapItemPrices.put(buttonAddToCartFleeceJacketID, priceFleeceJacket);
		buttonAddToCartFleeceJacket.click();
		logger.info("Adding into the cart this product {} with this price {}",buttonAddToCartFleeceJacketID,priceFleeceJacket);
		
		
		WebElement buttonAddToCartOnesie = driver.findElement(By.id(buttonAddToCartOnesieID));
		WebElement divPriceOnesie= buttonAddToCartOnesie.findElement(By.xpath(divPriceOnesieXPATH));
		float priceOnesie = Float.parseFloat(divPriceOnesie.getText().substring(1).trim());
		mapItemPrices.put(buttonAddToCartOnesieID, priceOnesie);
		buttonAddToCartOnesie.click();		
		logger.info("Adding into the cart this product {} with this price {}",buttonAddToCartBackPackID,priceOnesie);
		
		logger.info("Showing cart data {}",mapItemPrices);
		
		WebElement divCart = driver.findElement(By.id(divCartID));		
		divCart.click();
		
		return mapItemPrices;
		
	}

}
