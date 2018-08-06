package uiObjectsRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonFunctionsRepo.GenericMethods;
import driverRepo.DriverClass;


public class HomePageObjects extends DriverClass{
	

    private By logo_css = By.cssSelector(".nav-logo-link");
    private By navSignIn_id = By.id("nav-link-accountList");
	
	
	//Callable method to get logo element
	public WebElement getLogo() {
		genericMethods().waitForObjectExists(logo_css,GenericMethods.MAX_TIMEOUT);
		return driver.findElement(logo_css);	
	}
	
	
	//Callable method to get Nav Sign In
	public WebElement getSignIn() {
		genericMethods().checkElementExists("Nav Section - Sign In" , navSignIn_id);
		return driver.findElement(navSignIn_id);
	}
	
	
	
	
	
	
	
	
}
