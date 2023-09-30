package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataIntoSql {

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
		String query = "insert into my_data(first_name,last_name,address)values('ayesha', 'tayyaba', 'gulbarga')";
		int result = state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("data not updated");
		}

	}

}
