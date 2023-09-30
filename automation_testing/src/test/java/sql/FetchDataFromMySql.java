package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromMySql {

	public static void main(String[] args) throws Throwable
	{
		//object creation
		Driver driverref = new Driver();
		
		//register driver
		DriverManager.registerDriver(driverref);
		
		//connect to database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_selenium", "root", "root");
		
		//fetch data
		Statement state = connection.createStatement();
		
		//query
		String query = "select * from my_data";
		
		//fetch data
		ResultSet result = state.executeQuery(query);
		
		//result in consul
		while(result.next())
		{
			System.out.println(result.getString(1));
			System.out.println(result.getString(2));
			System.out.println(result.getString(3));
			System.out.println(result.getString(4));
		}
		connection.close();

	}

}
