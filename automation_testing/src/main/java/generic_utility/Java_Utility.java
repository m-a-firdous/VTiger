package generic_utility;

import java.util.Random;

public class Java_Utility
{
	/**
	 * This method is used to avoide duplicates
	 * @return
	 * @author Afeefa
	 */
	public int getRandomNumber()
	{
		Random RandomNumber = new Random();
		int r = RandomNumber.nextInt(1000);
		return r;
	}

}
