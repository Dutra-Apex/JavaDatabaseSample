package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	
	// This method inserts data into the rows of a given table on a given database
	public static void insertRows(String database, String tableName, String rows) 
	{
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {	 
			// Inserts a new row into the table
			statement.executeUpdate("INSERT INTO " + tableName + " VALUES" + rows);
			
			System.out.println("Rows added \n");
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }	

	}

}
