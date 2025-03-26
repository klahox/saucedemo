package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepTwo {
	
	public WebDriver driver;
	
	
	String divItemPriceXPATH= "//div[@class='inventory_item_price']";

	public CheckOutStepTwo( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public float checkTotalPrices() {
		
		
		List<WebElement> listDivPrices = driver.findElements(By.xpath(divItemPriceXPATH));
		
		float total = 0;
		for(WebElement divPrice: listDivPrices){
			
			float priceOfItem = Float.parseFloat(divPrice.getText().substring(1).trim());
			total = total + priceOfItem;
		}
		
		System.out.println(total);
		
		return total;
	}

}
