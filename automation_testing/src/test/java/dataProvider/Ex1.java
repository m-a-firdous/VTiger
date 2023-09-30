package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex1
{
	@Test(dataProvider="dataProviderExecute")
	public void bookTickets(String src, String dest)
	{
		System.out.println("Book ticket from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataProviderExecute()
	{
		Object[][] objarray = new Object[3][2];
		
		objarray[0][0]="Bangalore";
		objarray[0][1]="mumbai";
		
		objarray[1][0]="Bangalore";
		objarray[1][1]="hyderabad";
		
		objarray[2][0]="Bangalore";
		objarray[2][1]="chennai";
		
		return objarray;
	}

}
