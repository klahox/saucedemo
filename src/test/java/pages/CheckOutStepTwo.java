package pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwo {
	
	private static final Logger logger = LogManager.getLogger(CheckOutStepTwo.class);
	
	public WebDriver driver;
	
	public float subTotalPriceWeb;
	public float taxPriceWeb;
	public float totalPriceWeb;
	
	
	String divItemPriceXPATH= "//div[@class='inventory_item_price']";
	String divSubtotalPriceXPATH = "//div[@data-test='subtotal-label']";
	String divTaxXPATH = "//div[@data-test='tax-label']";
	String divTotalPriceXPATH = "//div[@data-test='total-label']";
	String buttonFinishID = "finish";

	public CheckOutStepTwo( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public boolean checkSumOfItemsIsEqualAsSubtotalPrice() {
		
		List<WebElement> listDivPrices = driver.findElements(By.xpath(divItemPriceXPATH));
		
		float sumOfPrices = 0;
		for(WebElement divPrice: listDivPrices){
			
			float priceOfItem = Float.parseFloat(divPrice.getText().substring(1).trim());
			sumOfPrices = sumOfPrices + priceOfItem;
		}
		logger.info("Summing the prices of all products {}",sumOfPrices);
		
		WebElement divSubtotalPrice=  driver.findElement(By.xpath(divSubtotalPriceXPATH));
		subTotalPriceWeb = Float.parseFloat(divSubtotalPrice.getText().split("\\$")[1].trim());
		logger.info("Getting the SUBTOTAL price from the web  {}",subTotalPriceWeb);
				
		if(sumOfPrices == subTotalPriceWeb){
			return true;
		}
		
		return false;
	}
	
	public boolean checkTaxIsCorrect(){
		
		WebElement divTaxPrice=  driver.findElement(By.xpath(divTaxXPATH));
		taxPriceWeb = Float.parseFloat(divTaxPrice.getText().split("\\$")[1].trim());
		logger.info("Getting the TAX price from the web  {}",taxPriceWeb);		
		
		float taxPriceCalculation = this.subTotalPriceWeb * 0.08f;
		
		logger.info("Getting the TAX price from Calculation  {}",taxPriceCalculation);	
		
		if(taxPriceCalculation == this.taxPriceWeb) {
			
			return true;
		}
		
		return false;
	}
	
	public boolean checkTotalPriceIsSubtotalPlusTax(){
		
		
		WebElement divTotalPrice=  driver.findElement(By.xpath(divTotalPriceXPATH));
		totalPriceWeb = Float.parseFloat(divTotalPrice.getText().split("\\$")[1].trim());
		logger.info("Getting the TOTAL price from the web  {}",totalPriceWeb);	
		
		float sumTaxAndSubtotal = this.subTotalPriceWeb + this.taxPriceWeb;
		
		logger.info("Getting the TOTAL price from the Calculation  {}",sumTaxAndSubtotal);	
		
		if( this.totalPriceWeb == sumTaxAndSubtotal) {
			return true;
		}
		
		return false;
	}
	
	
	public void clickOnFinish() {
		
		WebElement buttonFinish=  driver.findElement(By.id(buttonFinishID));
		buttonFinish.click();
	}
	

}
