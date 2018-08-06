package driverRepo;

import org.apache.commons.io.FileUtils;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestRunner;

import commonFunctionsRepo.GenericMethods;
import uiObjectsRepo.CommonPageObjects;
import uiObjectsRepo.CreateAccPageObjects;
import uiObjectsRepo.HomePageObjects;
import uiObjectsRepo.SignInPageObjects;


// Driver class defined with base driver configuration methods for
public class DriverClass 
{	
		
	
	public static WebDriver driver = null;
	public static int TCID ;
	public static String outPutReportsPath = "";
	public static String TestName;
	
	
	public int getTestCaseID()
	{
	return TCID;	
	}
	
	public  void setTestCaseID(int TCID)
	{
		this.TCID = TCID;
	}
	
	public  void setTestName(String TestName) {
		this.TestName = TestName ;
	} 
	
	public static void getDriver()
	{
		//Set local relative path of respective driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\balasubramanir\\eclipse-workspace\\ExternalJars\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

	}
	

	public static void closeDriver()
	{
		
		driver.close();
		driver.quit();
	}

	public static String getJsonData(String KeyName){
		
		try { 
		FileReader reader = new FileReader("C:\\Users\\balasubramanir\\eclipse-workspace\\Selenium-TestNG\\src\\TestData\\testJson.json");
		             JSONParser jsonParser = new JSONParser();	
		             JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		             return jsonObject.get(KeyName).toString();
		}catch(Exception e) {
			 Reporter.log("Error in reading data from test json file : " + e);
		}          
		
		return null;
	}
	

	public static String getExcelData(String ColumnName) throws IOException {
		
		FileInputStream file = new FileInputStream("D:/CCP/TestData.xls");
		HSSFWorkbook wb = new HSSFWorkbook(file);
		HSSFSheet ws = wb.getSheetAt(0);
		int columns = ws.getRow(0).getLastCellNum();
		String Testdata = "";
		
        for(int j = 0; j<columns; j++)
		{
			String Val = ws.getRow(0).getCell(j).getStringCellValue();
			if(Val.equals(ColumnName))
			{
				Testdata =  ws.getRow(TCID).getCell(j).getStringCellValue();
				return Testdata;
			}
		}
        
        return null;
	}
	
	
	public static void  reportScreenshot(String FileName) {
		try {
		           TakesScreenshot scrShot =((TakesScreenshot)driver);


	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                    String DestPath = outPutReportsPath + "\\" + TestName +"\\"+FileName+".png";
	                File DestFile=new File(DestPath);


	                FileUtils.copyFile(SrcFile, DestFile);
	                
	                Reporter.log("<br><img src='"+DestPath+"' height ='400' width = '500' /><br>");
		}
		catch(Exception e) {
			Reporter.log("Exception at take screenshot action : " + e);
		}
	}
		
		
	public GenericMethods genericMethods() {
		return new GenericMethods();
	}
	
	public CommonPageObjects commonPageObjects() {
		return new CommonPageObjects();
	}
	
	public HomePageObjects homePageObjects() {
		return new HomePageObjects();
	}
	
	public SignInPageObjects signInPageObjects() {
		return new SignInPageObjects();
	}
	
	public CreateAccPageObjects createAccPageObjects() {
		return new CreateAccPageObjects();
	}

	
	
	
	
	
	
}
