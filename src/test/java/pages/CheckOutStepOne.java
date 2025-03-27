package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutStepOne {
	
	private static final Logger logger = LogManager.getLogger(CheckOutStepOne.class);
	
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
		logger.info("Filling the input {} with data {}",inputFirstNameID,dataFirstName);
		
		WebElement inputLastName= driver.findElement(By.id(inputLastNameID));
		inputLastName.sendKeys(dataLastName);
		logger.info("Filling the input {} with data {}",inputLastNameID,dataLastName);
		
		WebElement inputPostalCode = driver.findElement(By.id(inputPostalCodeID));
		inputPostalCode.sendKeys(dataPostalCode);
		logger.info("Filling the input {} with data {}",inputPostalCodeID,dataPostalCode);
		
		WebElement buttonContinue = driver.findElement(By.id(buttonContinueID));		
		buttonContinue.click();
		logger.info("Clicking on button continue {}",buttonContinueID);
		
		
	}

}
