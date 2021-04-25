package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Class that displays data from a given table regarding COVID-19
public class CoronaTable {
	
	// Initializes Variables
	private String database;
	private String tableName;
	private String connection;
	
	//Constructor
	public CoronaTable(String database, String tableName)
	{
		this.database = database;
		this.tableName = tableName;
		this.connection = "jdbc:derby:" + database + ";create=true";
	}
	
	public void getAllData() 
	{
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		// Connects with database
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
	public void getDataWhere(String condition) 
	{
		try (Connection conn = DriverManager.getConnection(connection);		
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
	public void getDataWhere(String condition1, String condition2) 
	{		
		try (Connection conn = DriverManager.getConnection(connection);		
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
	public void findRatio(String column1, String column2) 
	{
		try (Connection conn = DriverManager.getConnection(connection);
				
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


