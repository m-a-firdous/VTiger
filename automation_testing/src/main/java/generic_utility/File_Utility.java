package generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility
{
	/**
	 * This method is used for login
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Afeefa
	 */
	public String getCredentials(String key) throws Throwable
	{
		//property file
				FileInputStream fis = new FileInputStream("./src/test/resources/vtiget.properties");
				Properties pro = new Properties();
				pro.load(fis);
				String Value = pro.getProperty(key);
				return Value;
	}

}
