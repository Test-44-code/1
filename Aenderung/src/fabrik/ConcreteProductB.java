package fabrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductB extends Product
{
BufferedReader bufferedReader;



public ConcreteProductB() 
{
	try {
		
	this.bufferedReader = new BufferedReader(new FileReader("bahnhof.txt"));
	} catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
}


public void schliesseDatei() throws IOException 
{
	this.bufferedReader.close();
}

public String[] leseAusDatei() throws IOException {
    
    String[] ergebnisZeile = new String[5];
    String zeile = bufferedReader.readLine();
    int i = 0;
    while (i<ergebnisZeile.length) 
    {
        ergebnisZeile[i] = zeile;
        zeile = bufferedReader.readLine();
        i++;
    }
    return ergebnisZeile;
}
}


