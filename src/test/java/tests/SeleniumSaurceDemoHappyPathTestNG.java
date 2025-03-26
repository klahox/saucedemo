package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Products;
import pages.Cart;
import pages.Login;



public class SeleniumSaurceDemoHappyPathTestNG {
	
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\klajd\\Documents\\repositories\\saucedemo\\driver\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");	  
  }
  
  @Test
  public void testThatTotalPriceIsCorrect() {
	  
	  Login login = new Login(driver);
	  login.loginWithStandartUser();
	  
	  Products products = new Products(driver);
	  products.savePricesAndAddToCart();
	  
	  Cart myCart = new Cart(driver);
	  myCart.checkOut();
	  
	  
  }


  @AfterMethod
  public void afterMethod() {
	  
		//Obtengo la fecha actual con formato hasta segundos para ponerlo en el fichero de salida
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentDateTime = dateFormat.format(currentDate);
		
		//Hacemos una captura de pantalla y mostramos la ruta del fichero		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("captura"+currentDateTime+".png");
		
		try {
			FileUtils.copyFile(srcFile,destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ruta de la caputa => "+destFile.getAbsolutePath());
		
		//Close and quit
		driver.close();
		driver.quit();	  
  }

}
