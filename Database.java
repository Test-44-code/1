package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
	
	private String user;
	private String password;
	private String url;
	Connection connection;
	
	
	
	public void setUser(String user) 
	{
		this.user = user;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public void setUrl(String ip, int port,String nameDB) 
	{
		this.url = "jdbc:postgresql://" + ip + ":" +  port + "/"  +nameDB;
	}

	public Database() 
	{
		loadJdbcDriver();
	}

	private void loadJdbcDriver()
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBC-Treiber geladen");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("Fehler beim Laden des Treibers: " +e.getMessage());
			System.exit(1);
		}
		
	}
	
	public void openConnection()
	{
		try 
		{
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("Datenbenk geöffnet");
		} catch (SQLException e) 
		{
			System.out.println("Fehler beim Öffnen" + e.getMessage());
		}
	}
	
	public void closeConnection()
	{
		try 
		{
			connection.close();
			System.out.println("Datenbank geschlossen");
		} catch (SQLException e) 
		{
			System.out.println("Fehler beim Schließen " + e.getMessage());
		}
	}
	
	public void dbQuery(String sql)
	{
		try 
		{
			Statement state = connection.createStatement();
			state.executeUpdate(sql);
			System.out.println("Erfolgreich ausgeführt " + sql);
		} catch (SQLException e) 
		{
			System.out.println("Fehler beim excuten" + e.getMessage());
		}
	}
	public ArrayList<String[]> dbQueryResult(String sQuery)
	{
		ArrayList<String[]> aResult = new ArrayList<String[]>();
		try 
		{
			Statement state = connection.createStatement();
			ResultSet result = state.executeQuery(sQuery); 
			ResultSetMetaData rsmd = result.getMetaData(); 
			int cCount = rsmd.getColumnCount(); 
		while (result.next()) 
		{ 
			String sRow[] = new String[cCount]; 
			for (int i=0;i<cCount;i++) 
			sRow[i]=result.getString(i+1); 
			aResult.add(sRow);
		}
		}
		catch (SQLException e) 
		{
			System.out.println("Fehler " + e.getMessage());
		}
		return aResult;
	} 
	
}
