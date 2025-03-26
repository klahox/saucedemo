package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepOne {
	
	String inputFirstNameID = "first-name";
	String inputLastNameID = "last-name";
	String inputPostalCodeID = "postal-code";
	String buttonContinueID = "continue";	
	
	String dataFirstName = "Klajdi";
	String dataLastName="Hoxha Sina";
	String dataPostalCode = "41920";
	
	public WebDriver driver;
	
	
	public CheckOutStepOne( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public void fillDataAndContinue() {
		

		WebElement inputFirstName = driver.findElement(By.id(inputFirstNameID));
		inputFirstName.sendKeys(dataFirstName);
		
		WebElement inputLastName= driver.findElement(By.id(inputLastNameID));
		inputLastName.sendKeys(dataLastName);
		
		WebElement inputPostalCode = driver.findElement(By.id(inputPostalCodeID));
		inputPostalCode.sendKeys(dataPostalCode);
		
		WebElement buttonContinue = driver.findElement(By.id(buttonContinueID));		
		buttonContinue.click();
		
		
	}

}
