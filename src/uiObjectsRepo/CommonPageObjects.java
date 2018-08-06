package uiObjectsRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverRepo.DriverClass;

public class CommonPageObjects extends DriverClass {

	public By pageHeader_tag    = By.tagName("h1");
	
	
	public WebElement getPageHeader() {	
        genericMethods().checkElementExists("Header Text",pageHeader_tag);
        return driver.findElement(pageHeader_tag);
	}

	
	
}
