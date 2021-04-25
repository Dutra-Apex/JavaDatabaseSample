package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// This class was made for specific use on the COVID-19 table
public class GetData 
{
	// Method that prints all the data of a given table
	// Made for specific use for the "COVID-19" Table
	public static void getAllData(String database, String tableName) 
	{
		// Connects with database
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates the statement object
		Statement statement = conn.createStatement();
		// Gets information from the Database
		ResultSet resultset = statement.executeQuery("SELECT * FROM " + tableName))
		{
			while (resultset.next()) {
				 System.out.print("Country: ");
				 System.out.println(resultset.getString("Country"));
				 System.out.print("Number of active cases: ");
				 System.out.println(resultset.getInt("Cases"));
				 System.out.print("Number of deaths: ");
				 System.out.println(resultset.getInt("Deaths"));
				 System.out.print("Number of recoveries: ");
				 System.out.println(resultset.getInt("Recovered"));
				 System.out.print("Gross Domestic Product (in trillions of US$): ");
				 System.out.println(resultset.getDouble("GDP"));
				 System.out.print("Human Developmen Index: ");
				 System.out.println(resultset.getDouble("HDI"));
				 System.out.print("Has Universal Healthcare? ");
				 System.out.println(resultset.getBoolean("HealthCare"));
				 System.out.print("Population: ");
				 System.out.println(resultset.getInt("Population"));
				 System.out.print("\n");
				 }
		}
		
		 catch (SQLException e) {
			 e.printStackTrace();
		 }		 
	}
	
	
	// Method that prints the list of all countries that meet the given condition
	public static void getDataWhere(String database, String tableName, String condition) 
	{
		
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
				
		try (Connection conn = DriverManager.getConnection(CONNECTION);		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT * FROM " + tableName + " WHERE " + condition)) 
		{	 
			//Print countries the meet the condition
			System.out.println("Countries where " + condition);
			while (resultset.next()) {
				System.out.println(resultset.getString("Country"));
			}
		
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}		
	}
	
	// Overloaded method that works with two conditions
	public static void getDataWhere(String database, String tableName, String condition1, String condition2) 
	{
		
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
			
		try (Connection conn = DriverManager.getConnection(CONNECTION);
				
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT * FROM " + tableName + " WHERE " + condition1 + " AND " + condition2)) 
		{	 
			//Print countries the meet the conditions
			System.out.println("Countries where " + condition1 + " and " + condition2);
			while (resultset.next()) {
				System.out.println(resultset.getString("Country"));
			}
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}		
	}
	
	
	
	
	// Method that prints the ratio of between 2 variables. Made for specific use on all numeric columns
	public static void findRatio(String database, String tableName, String column1, String column2) 
	{
		
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";

		try (Connection conn = DriverManager.getConnection(CONNECTION);
				
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT Country, " + column1 + ", " + column2 + " FROM " + tableName)) 
		{	 
			while (resultset.next()) {
				
				//Calculate the ratio
				double value1 = resultset.getInt(column1);
				double value2 = resultset.getInt(column2);
				double ratio = (value1/value2)*100;
				
				// Print list of countries and the ratios between the given columns
				System.out.print("Country: ");
				System.out.println(resultset.getString("Country"));
				System.out.print("Percentage between " + column1 + " and " + column2 + ": ");
				System.out.println(ratio + "%");
				System.out.println("\n");
			}
		
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}		
	}
	
}


