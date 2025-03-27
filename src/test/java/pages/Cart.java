package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
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
	
	
	
	
	
	
	

}
