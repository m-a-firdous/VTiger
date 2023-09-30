package testNG;

import org.testng.annotations.Test;

@Test
public class Product1
{
	public void createproduct()
	{
		System.out.println("product created");
	}
	
	public void modifyproduct()
	{
		System.out.println("product modified");
	}
	
	public void deleteproduct()
	{
		System.out.println("product delete");
	}

}
