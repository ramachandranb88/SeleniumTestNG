package testScriptsRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.*;
import driverRepo.DriverClass;
import testFunctionsRepo.BusinessComponent;




public class SignInPageTest  {

	BusinessComponent testFlow = new BusinessComponent();
	
	@BeforeTest
	public static void setup(ITestContext ctx) {
	TestRunner runner = (TestRunner) ctx;
	DriverClass.outPutReportsPath = System.getProperty("user.dir")+"\\Reports\\"+ctx.getCurrentXmlTest().getSuite().getName()+ "_"+new SimpleDateFormat("dd_MM_HH_mm_ss").format(new Date());
	runner.setOutputDirectory(DriverClass.outPutReportsPath);
//	ctx.getCurrentXmlTest().getSuite().getName();
	}

	//@BeforeMethod  - Can be called when new driver needs to be initialized for every test cases
	//@BeforeMethod
	@BeforeClass
	public void setUp()
	{
		DriverClass.getDriver();
	}
	
	@AfterClass
	public void close()
	{
		DriverClass.closeDriver();
	}
	
		
	@Test (groups={"base2"},dependsOnGroups= {"base1"})
	public void homepageTest() 
	{		
		//setTestCaseID(1);
		new DriverClass().setTestName((new Throwable().getStackTrace())[0].getMethodName().toString());
		testFlow.launchURL("https://www.amazon.com/");
		Reporter.log("Browser Opened");
		testFlow.verifyHomePage();
	}
	

   @Test (groups= {"base2"},dependsOnGroups= {"base1"},dependsOnMethods= {"homepageTest"})
	public void signInPageNavTest()	
	{	
		new DriverClass().setTestName((new Throwable().getStackTrace())[0].getMethodName().toString()); 	
	    testFlow.navSignInPage();
	}
	
	@Test(groups= {"base2"},dependsOnGroups= {"base1"},dependsOnMethods= {"signInPageNavTest"})
    public void createAccPageNavTest()
	{
		new DriverClass().setTestName((new Throwable().getStackTrace())[0].getMethodName().toString());
		testFlow.navCreateAccount();
	}

	
	
	
}
	
	
	/*public  String getData(String ColumnName) throws IOException {
		
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
				Testdata =  ws.getRow(AutoHandsOn.TCID).getCell(j).getStringCellValue();
				return Testdata;
			}
		}
        
        return null;
		
		/*
		String inputData [][] = new String [rows][columns];
		for(int i = 0 ; i<rows ; i++)
		{
			for(int j = 0; j<columns; j++)
			{
				inputData[i][j] = ws.getRow(i).getCell(j).getStringCellValue();
			}
			
			
		}
		
		
	} */
	
	

