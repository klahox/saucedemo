package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
	
	String buttonCheckoutID ="checkout";
	
	WebDriver driver;
	
	public Cart( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public void checkOut() {
		
		WebElement buttonCheckout = driver.findElement(By.id(buttonCheckoutID));
		buttonCheckout.click();
		
	}
	
	
	
	
	
	
	

}
