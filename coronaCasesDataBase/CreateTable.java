package coronaCasesDataBase;

/**
 	11/8/20

 	Program: Table and Database creation
 	Written by: Gabriel Dutra
 	
 	This code connects to the Derby database and creates a database and a table made to hold 
 	relevant information regarding the COVID-19 in a country.
 	
 	Work reference: Barry Burd’s Java for Dummies Chapter 17: Using Java Database Connectivity 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	// This method creates a table and a database
	public static void createTable(String database, String tableName, String columns) 
	{		
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {		
				 // Creates a table with the given name and columns
				 // Datatype of the columns must be added!
				 statement.executeUpdate("CREATE TABLE " + tableName + columns);
				 System.out.println(tableName + " table created in the " + database + " database. \n");
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }			 
	}
}
