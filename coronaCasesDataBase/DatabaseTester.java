package coronaCasesDataBase;

import java.util.Scanner;

public class DatabaseTester {

	public static void main(String[] args) {
		
		// Variables related to the Covid-19 table
		String database = "FinalProject";
		String tableName = "Covid19";
		
		String columns = " (Country VARCHAR(32) NOT NULL PRIMARY KEY, "
				 			+ "Cases INT, " + "Deaths INT,"
				 			+ "Recovered INT, "+ "GDP DOUBLE,"
				 			+ "HDI DOUBLE," + "HealthCare BOOLEAN,"
				 			+ "Population INT )";
		
		String rows = " ('United States', 2545824, 212660, 4736131, 19.49, 0.92, false, 328200000), " 
	 					+ " ('China', 186, 4634, 80594, 12.24, 0.76, true, 1439320000 ), " 
	 					+ " ('Brazil', 491690, 144767, 4212772 ,2.05, 0.76, true, 212560000), " 
	 					+ " ('Russia', 200098, 20891, 1185231, 1.58, 0.82, true, 145930000), " 
	 					+ " ('Vietnam', 50, 35, 1010, 0.22, 0.69, true, 97340000), "
	 					+ " ('New Zealand', 53, 25, 1770, 0.2, 0.92, true, 4820000) ";
		
		//DropTable.dropTable(database, tableName);
		
		// Creates a new Table in the database
		// The table has 8 columns: Country, Covid19 Number of: Cases, Deaths and recoveries,
		// Gross Domestic Product(GDP, in US$ Trillions) , Human Development Index (HDI),
		// Universal HealthCare availability, Population.
		CreateTable.createTable(database, tableName, columns);
		
		
		// Insert all the data in the 'rows' variable to the table
		InsertData.insertRows(database, tableName, rows);
		
		// Creates a new 'CoronaTable' object 
		CoronaTable a = new CoronaTable(database, tableName);

		// Starts the interactive menu
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("To interact with the created database, input a number based on the following: \n" 
							+ "1: Get all data currently on the table \n"
							+ "2: Get all data from countries that meet a given condition \n"
							+ "3: Get all data from countries that meet two given conditions \n"
							+ "4: Get the ratio between two numerical columns in the data \n"
							+ "5: Update the table \n"
							+ "6: Delete a row on the table \n"
							+ "7: Remove the table from the database \n"
							+ "0: Exit the Program \n");
		
		int input = 1;
		while (input != 0) 
		{
			System.out.print("Your input: ");
			input = user_input.nextInt();
			switch(input) 
			{
			case 1:
				a.getAllData();
				break;
				
			case 2:
				System.out.println("What is the condition?");
				a.getDataWhere(" " + user_input.next());
				break;
				
			case 3:
				System.out.println("What are the conditions?");
				String c1 = user_input.next();
				String c2 = user_input.next();
				a.getDataWhere(c1, c2);
				break;
			
			case 4:
				System.out.println("What are the columns");
				String co1 = user_input.next();
				String co2 = user_input.next();
				a.findRatio(co1, co2);
				break;
			
			case 5:
				System.out.println("What is the update?");
				String update = user_input.next();
				System.out.println("What is the condition?");
				String condition = user_input.next();
				UpdateTable.updateTable(database, tableName, update, condition);
				break;
				
			case 6:
				System.out.println("What is the condition?");
				String condition2 = user_input.next();
				DeleteRow.deleteRow(database, tableName, condition2);
				break;
				
			case 7:
				DropTable.dropTable(database, tableName);
				break;
				
			default:
				System.out.print("Exited");
			}
		}
		
	}

}
