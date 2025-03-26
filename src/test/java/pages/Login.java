package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
//	String buttonAcceptCookiesID = "L2AGLb";	
	
	String inputUserNameID = "user-name";
	String inputPasswordID = "password";
	String inputButtonID = "login-button";
	
	String dataUsername = "standard_user";
	String dataPassword = "secret_sauce";
	
	
	WebDriver driver;
	
	public Login( WebDriver driver){
		
		this.driver= driver;
		
	}
	
	public void loginWithStandartUser() {
		
		
		WebElement inputUserName = driver.findElement(By.id(inputUserNameID));
		inputUserName.sendKeys(dataUsername);
		
		WebElement inputPassword = driver.findElement(By.id(inputPasswordID));
		inputPassword.sendKeys(dataPassword);
		
		WebElement inputButton = driver.findElement(By.id(inputButtonID));
		inputButton.click();
		
		System.out.println("Login: Login with UserName "+dataUsername+" and Password = "+dataPassword);
		
	}
	

}
