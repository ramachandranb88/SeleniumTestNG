package uiObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverRepo.DriverClass;

public class CreateAccPageObjects extends DriverClass {

	public By name_id    = By.name("customerName");
	public By email_css  = By.cssSelector("#app_email");
	public By password_css = By.cssSelector("#ap_password");
	public By passwordCheck_css = By.cssSelector("ap_password_check");
	public By createAccBtn_Xpath = By.xpath(".//input[@class='a-button-input']");
	
	
	public WebElement getNamefield() {
		genericMethods().checkElementExists("Create Account - UserName Text",name_id);
		return driver.findElement(name_id);		
	}
	
	
	public WebElement getEmailfield() {
		genericMethods().checkElementExists("Create Account - Email Text",email_css);
		return driver.findElement(email_css);
	}
	
	
	public WebElement getPasswordfield() {
		genericMethods().checkElementExists("Create Account - Passowrd Text",password_css);
		return driver.findElement(password_css);
	}
	
	public WebElement getConfirmPswdfield() {
		genericMethods().checkElementExists("Create Account - Confirm Password Text", passwordCheck_css);
		return driver.findElement(passwordCheck_css);
	}
	
	public WebElement getCreateAccBtn() {
		genericMethods().checkElementExists("Create Account - Create Account Btn",createAccBtn_Xpath);
		genericMethods().waitForObjectClickable(createAccBtn_Xpath);
		return driver.findElement(createAccBtn_Xpath);
	}
	
}
