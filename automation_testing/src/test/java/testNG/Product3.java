package testNG;

import org.testng.annotations.Test;

public class Product3 // to not execute particular method
{
	@Test(enabled =false)
	public void createproduct()
	{
		System.out.println("product created");
	}
	
	@Test
	public void modifyproduct()
	{
		System.out.println("product modified");
	}
	
	@Test
	public void deleteproduct()
	{
		System.out.println("product delete");
	}

}
