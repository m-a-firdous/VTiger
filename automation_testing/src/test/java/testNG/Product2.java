package testNG;

import org.testng.annotations.Test;

public class Product2
{
	@Test(priority = -1)
	public void createproduct()
	{
		System.out.println("product created");
	}
	
	@Test(priority = 0)
	public void modifyproduct()
	{
		System.out.println("product modified");
	}
	
	@Test(priority = 1)
	public void deleteproduct()
	{
		System.out.println("product delete");
	}

}
