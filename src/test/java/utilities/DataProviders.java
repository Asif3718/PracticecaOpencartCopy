package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";    //taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);            //creating an object for XLIUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);   //sheet name and row number
		
		String logindata[][]=new String[totalrows][totalcols];  //created for two dimension array wjich can store...(ignoring header part i.e r=0)
		
		//In array row starts from 0 abd col from 1.
		
		for(int i=1;i<=totalrows;i++)        //read the data from excel sheet and copied into the two-dim array
		{
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= xlutil.getCellData("sheet1", i, j);    //1,0
			}
		}
		return logindata;   //returning two dimensional array		
	}
	
	//DataProvider 2
	
	//DataProvider 3

}
