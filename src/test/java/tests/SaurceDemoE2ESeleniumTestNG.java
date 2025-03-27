package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Products;
import pages.Cart;
import pages.CheckOutStepOne;
import pages.CheckOutStepTwo;
import pages.CheckoutComplete;
import pages.Login;



public class SaurceDemoE2ESeleniumTestNG {
	
	private static final Logger logger = LogManager.getLogger(SaurceDemoE2ESeleniumTestNG.class);
	
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	//Starting the webdriver
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\klajd\\Documents\\repositories\\saucedemo\\driver\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");	  

  }
  
  @Test
  public void testThatTotalPriceIsCorrect() {
	  
	  logger.info("Starting tests...");

	  // Login page User pass
	  Login login = new Login(driver);
	  login.loginWithStandartUser();
	  
	  //Adding productos into the cart
	  Products products = new Products(driver);
	  products.savePricesAndAddToCart();
	  
	  //Starting checkout
	  Cart myCart = new Cart(driver);
	  myCart.checkOut();
	  
	  //Adding User Data for checkout
	  CheckOutStepOne stepOne = new CheckOutStepOne(driver);
	  stepOne.fillDataAndContinue();
	  
	  //On summary page, checking the prices
	  CheckOutStepTwo stepTwo = new CheckOutStepTwo(driver);
	  Assert.assertTrue(stepTwo.checkSumOfItemsIsEqualAsSubtotalPrice(),"The sum of prices should be equal as the subtotal"); 
	  Assert.assertTrue(stepTwo.checkTotalPriceIsSubtotalPlusTax(),"The Total price should be correct"); 
	  stepTwo.clickOnFinish();
	  
	  //Finishing the order and checking the finish page
	  CheckoutComplete finish = new CheckoutComplete(driver);
	  Assert.assertTrue(finish.checkThatOrderIsFinished(),"In the finish page should be shown the OK image, the header, text and back button");
  }


  @AfterMethod
  public void afterMethod() {
	  
	  
		//Getting the current date for sceenshot name  
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDateTime = dateFormat.format(currentDate);
		
		//Getting the screenshot and saving it including in the name the current date
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("captura"+currentDateTime+".png");
		
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Screenshot Absoulte path => {}",destFile.getAbsolutePath());
		
		//Close and quit
		driver.close();
		driver.quit();	  
		
  }

}
