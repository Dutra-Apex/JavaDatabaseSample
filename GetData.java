/**
 	10/15/20
 	Program: Get data from database
 	Written by: Gabriel Dutra
 	
 	This code connects to the Derby database "Countries_Corona" and prints its information
 	Work reference: Barry Burd’s Java for Dummies Chapter 17: Using Java Database Connectivity 
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

	public static void main(String[] args) {
		
		// Connects with database
		final String CONNECTION = "jdbc:derby:SampleDatabase";
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates the statement object
		Statement statement = conn.createStatement();
		// Gets information from the Database
		ResultSet resultset = statement.executeQuery("SELECT * FROM Countries_Corona"))
		{
			while (resultset.next()) {
				 System.out.print("Country: ");
				 System.out.print(resultset.getString("Country"));
				 System.out.print(", Number of active cases: ");
				 System.out.print(resultset.getInt("Cases"));
				 System.out.print(", Number of deaths: ");
				 System.out.println(resultset.getInt("Deaths"));
				 }
		}
		
		 catch (SQLException e) {
			 e.printStackTrace();
			 }
	}
}
