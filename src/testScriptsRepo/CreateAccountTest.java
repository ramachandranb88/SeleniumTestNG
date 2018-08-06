package testScriptsRepo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.*;
import driverRepo.DriverClass;
import testFunctionsRepo.BusinessComponent;



public class CreateAccountTest  {

	BusinessComponent testFlow = new BusinessComponent();
    


	
	//@BeforeMethod  - Can be called when new driver needs to be initialized for every test cases
	//@BeforeMethod
	//@BeforeMethod
	@BeforeClass
	public void setUp() throws FileNotFoundException, IOException
	{
		DriverClass.getDriver();
	}
	
	@AfterClass
	public void close()
	{
		DriverClass.closeDriver();
	}
	

	@Test(groups= {"base1"})
	public void createAccPageNavTest()
	{
		new DriverClass().setTestName((new Throwable().getStackTrace())[0].getMethodName().toString());
		testFlow.launchURL("https://www.amazon.com/");
		testFlow.verifyHomePage();
		testFlow.navSignInPage();
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
	
	

