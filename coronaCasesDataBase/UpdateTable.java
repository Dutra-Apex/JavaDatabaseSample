package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
	
	//This method updates a row that meets a condition
	public static void updateTable(String database, String tableName, 
								   String update, String condition) 
	{
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {	 
			// Updates the table
			statement.executeUpdate("UPDATE " + tableName + " SET " + update + " WHERE " + condition);
			System.out.println("Table " + tableName +  " updated \n");
		 } 
		
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }	
	}
}
