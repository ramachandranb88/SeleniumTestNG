package testFunctionsRepo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverRepo.DriverClass;



public class BusinessComponent extends DriverClass{
	
	public void launchURL(String uRL) 
	{
		driver.get(uRL);
		genericMethods().WaitForPageLoad(driver, 10);
		Assert.assertEquals(driver.getTitle(),getJsonData("homePage_Title"));        
	}
	
	public void verifyHomePage()
	{
		genericMethods().WaitForPageLoad(driver, 10);
		WebElement logo = homePageObjects().getLogo();
		Assert.assertTrue(logo.isDisplayed(),"Verify Logo is displayed : ");
		Assert.assertEquals("Amazon", logo.getText());
		reportScreenshot("HomePage");

	}
	
	
	public void navSignInPage()
	{
		WebElement navSignIn = homePageObjects().getSignIn();
        navSignIn.click();
        genericMethods().WaitForPageLoad(driver,10);
        Assert.assertEquals(getJsonData("signInPage_Title"), driver.getTitle());
        Assert.assertTrue(commonPageObjects().getPageHeader().isDisplayed());
        Assert.assertEquals(commonPageObjects().getPageHeader().getText(), "Sign in");
        reportScreenshot("SignInPage");
	}
	
	public void verifysignInPageObjects()
	{
		navSignInPage();
		signInPageObjects().getemailText_name().sendKeys(getJsonData("login_Email"));
        signInPageObjects().getContinueBtn().click();
        Assert.assertTrue(signInPageObjects().getPasswordText_name().isDisplayed());
        Assert.assertTrue(signInPageObjects().getContinueBtn().isEnabled());
	}
	
	public void navCreateAccount() 
	{
	    signInPageObjects().getCreateAccBtn().click();
	    genericMethods().WaitForPageLoad(driver,10);
	    Assert.assertEquals(getJsonData("creatAccPage_Title"), driver.getTitle());
        Assert.assertTrue(commonPageObjects().getPageHeader().isDisplayed());
        Assert.assertEquals(commonPageObjects().getPageHeader().getText(), "Create account");
        reportScreenshot("CreateAccountPage");
	}
	
	public void verifyCreateAccount()
	{
        navCreateAccount();
		createAccPageObjects().getNamefield().sendKeys(getJsonData("createAcc_Name"));
        createAccPageObjects().getEmailfield().sendKeys(getJsonData("createAcc_Email"));
        createAccPageObjects().getPasswordfield().sendKeys(getJsonData("createAcc_Password"));
        createAccPageObjects().getConfirmPswdfield().sendKeys(getJsonData("createAcc_Password"));
        Assert.assertTrue(createAccPageObjects().getCreateAccBtn().isEnabled());
     }
	
	
	


	
}
