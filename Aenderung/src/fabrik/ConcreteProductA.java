package fabrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product
{
BufferedReader bufferedReader;



public ConcreteProductA() 
{
	try {
		
	this.bufferedReader = new BufferedReader(new FileReader("bahnhof.csv"));
	} catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
}


public void schliesseDatei() throws IOException 
{
	this.bufferedReader.close();
}

@Override
public String[] leseAusDatei() throws IOException {
	String [] array =  bufferedReader.readLine().split(";");
	return array;
}

}


