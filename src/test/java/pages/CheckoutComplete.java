package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {
	
	private static final Logger logger = LogManager.getLogger(CheckOutStepOne.class);
	
	String imgPonyExpressXPATH= "//img[@data-test='pony-express']";
	String h2CompleteHeaderXPATH = "//h2[@data-test='complete-header']";
	String divCompleteTextXPATH = "//div[@data-test='complete-text']";
	String buttonBackToProductsID = "back-to-products";
	
	public WebDriver driver;
	
	
	public CheckoutComplete( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public boolean checkThatOrderIsFinished() {
		
		if(!driver.findElement(By.xpath(imgPonyExpressXPATH)).isDisplayed()) {
			
			logger.error("The IMAGE is not displayed Xapth={}",imgPonyExpressXPATH);
			return false;
		}
		
		if(!driver.findElement(By.xpath(h2CompleteHeaderXPATH)).isDisplayed()) {
			
			logger.error("The H2 Complete Header is not displayed Xapth={}",h2CompleteHeaderXPATH);
			return false;
		}
		
		if(!driver.findElement(By.xpath(divCompleteTextXPATH)).isDisplayed()) {
			
			logger.error("The DIV Complete Text is not displayed Xapth={}",divCompleteTextXPATH);
			return false;
		}
		
		if(!driver.findElement(By.id(buttonBackToProductsID)).isDisplayed()) {
			
			logger.error("The BUTTON Back Home is not displayed Xapth={}",buttonBackToProductsID);
			return false;
		}		
			
	
		return true;
	}
	

}
