package coronaCasesDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropTable {

	//This method completely removes a table from a database
	public static void dropTable(String database, String tableName) {
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:" + database + ";create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {	 
			// 	Drops the table
			statement.executeUpdate("DROP TABLE " + tableName);
				 System.out.println("Table " + tableName + " removed from database " + database + "\n");
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }	
	}
}
