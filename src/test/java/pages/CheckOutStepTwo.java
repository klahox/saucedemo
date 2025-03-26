package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwo {
	
	public WebDriver driver;
	
	
	String divItemPriceXPATH= "//div[@class='inventory_item_price']";
	String divSubtotalPricesXPATH = "//div[@data-test='subtotal-label']";

	public CheckOutStepTwo( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public boolean checkTotalPrices() {
		
		boolean areEqual = false; 
		
		List<WebElement> listDivPrices = driver.findElements(By.xpath(divItemPriceXPATH));
		
		float sumOfPrices = 0;
		for(WebElement divPrice: listDivPrices){
			
			float priceOfItem = Float.parseFloat(divPrice.getText().substring(1).trim());
			sumOfPrices = sumOfPrices + priceOfItem;
		}
		
		System.out.println("SumOfPrices =>"+ sumOfPrices);
		
		WebElement divSubtotalPrice=  driver.findElement(By.xpath(divSubtotalPricesXPATH));

		Float subTotalPrice = Float.parseFloat(divSubtotalPrice.getText().split("\\$")[1].trim());
		
		System.out.println("SubTotalPrices =>"+subTotalPrice);
			
		if(sumOfPrices != subTotalPrice){
			return true;
		}
		
		return areEqual;
	}

}
