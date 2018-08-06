package uiObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverRepo.DriverClass;

public class SignInPageObjects extends DriverClass {

	public By signInHeader_tag    = By.tagName("h1");
	public By emailText_name      = By.name("email");
	public By passwordText_name   = By.name("password");
	public By continueBtn_id      = By.id("continue");
	public By createAccBtn_id     = By.id("createAccountSubmit");
	
	
	
	public WebElement getSignInHeader() {
         genericMethods().checkElementExists("Sign In Page Header Text",signInHeader_tag);
         return driver.findElement(signInHeader_tag);
	}
	
	
	public WebElement getemailText_name() {
		genericMethods().checkElementExists("Login email text field",emailText_name);
		return driver.findElement(emailText_name);
	}
	
	
	public WebElement getPasswordText_name() {
		genericMethods().checkElementExists("Password email text field",passwordText_name);
		return driver.findElement(passwordText_name);
	}
	
	public WebElement getContinueBtn() {
		genericMethods().checkElementExists("Sign In Continue Button",continueBtn_id);
		genericMethods().waitForObjectClickable(continueBtn_id);
		return driver.findElement(continueBtn_id);
	}
	
	public WebElement getCreateAccBtn() {
		genericMethods().checkElementExists("Create Account Button",createAccBtn_id);
		genericMethods().waitForObjectClickable(createAccBtn_id);
		return driver.findElement(createAccBtn_id);
	}
	
	
}
