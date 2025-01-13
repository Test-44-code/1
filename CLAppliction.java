package dbconnection;

import java.util.ArrayList;

public class CLAppliction {

	public static void main(String[] args) 
	{
		Database database = new Database();
		
		database.setUser("postgres");
		database.setPassword("root");
		database.setUrl("localhost", 5432, "Praktikum V4");
		
		database.openConnection();
		
		database.dbQuery("SET search_path TO versuch4;");
		database.dbQuery("CREATE TABLE abteilung (aid SERIAL PRIMARY KEY,name VARCHAR (50));");
		database.dbQuery("CREATE TABLE mitarbeiter (mid SERIAL PRIMARY KEY , name VARCHAR(50),vorname VARCHAR (50), aid INT REFERENCES abteilung (aid));");
		
		database.dbQuery("INSERT INTO abteilung (name) VALUES ('HR'), ('IT'), ('Finance')");
	    database.dbQuery("INSERT INTO mitarbeiter (name, vorname, aid) VALUES " +
	                   "('Müller', 'Hans', 1), " +
	                   "('Schmidt', 'Anna', 2), " +
	                   "('Schneider', 'Peter', 3)");
	    
	    System.out.println("Die Daten der Tabelle Mitarbeiter" + "\n");
	    
	    ArrayList<String[]> results = database.dbQueryResult("SELECT * FROM mitarbeiter");
	    for (String[] row : results) 
	    {
			for (String value : row) 
			{
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	    
	    System.out.println("\n" + "Die Daten der Tabelle Mitarbeiter" + "\n");
	    ArrayList<String[]> results2 = database.dbQueryResult("SELECT * FROM abteilung");
	    for (String[] row : results2) 
	    {
			for (String value : row) 
			{
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	    
	    
	    
		database.closeConnection();
	}

}
