/**
 	10/15/20
 	Program: Database connectivity and creation
 	Written by: Gabriel Dutra
 	
 	This code connects to the Derby database and creates a sample database 
 	that will be used in later in the project.
 	Work reference: Barry Burd’s Java for Dummies Chapter 17: Using Java Database Connectivity 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToDatabase {

	public static void main(String[] args) {		
		// Creates the database using derby
		final String CONNECTION = "jdbc:derby:SampleDatabase;create=true";
		
		// Connects with the created database
		try (Connection conn = DriverManager.getConnection(CONNECTION);
		
		// Creates a statement object
		// This object takes SQL code to update the database
		Statement statement = conn.createStatement()) 
		 {
				// Creates a new Table in the database named Countries_Corona
				// The table has 3 columns: Country, Cases and Deaths 
				 statement.executeUpdate("CREATE TABLE Countries_Corona" +
				 " (Country VARCHAR(32) NOT NULL PRIMARY KEY, " +
				 " Cases INT, " +
				 " Deaths INT,"
				 + "GDP FLOAT,"
				 + "HDI FLOAT,"
				 + "HealthCare BOOLEAN,"
				 + "Population INT )");
				 System.out.println("'Countries_Corona' table created.");
				 
				 // Inserts a new row into the table
				 statement.executeUpdate("INSERT INTO Countries_Corona VALUES" +
						 " ('United States', 2545824, 212660, 1.1, 1.1, False, 8654) ");
				 System.out.println("Row added");
		 } 
		 catch (SQLException e) 
		 {
			 e.printStackTrace();
		 }			 
	}
}
