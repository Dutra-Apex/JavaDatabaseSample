package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRow {
	
	// This method deletes a row that meets a certain condition
	
	public static void deleteRow(String database, String tableName, String condition) {
		
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {	 
			// Deletes a row from the table
			statement.executeUpdate("DELETE FROM " + tableName + " WHERE " + condition);
				 System.out.println("Row removed from database " + database + "\n");
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }	

	}

}
