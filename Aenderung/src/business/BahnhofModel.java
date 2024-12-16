package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import fabrik.ConcreteCreatorA;
import fabrik.ConcreteCreatorB;
import fabrik.Creator;
import fabrik.Product;
import ownUtil.Observable;
import ownUtil.Observer;


public class BahnhofModel implements Observable  {
	//Bahnhof bahnhof;
	ArrayList<Bahnhof> bahnhoefe= new ArrayList<Bahnhof>(); 
	BufferedReader ein;
	private static BahnhofModel ob;
	private Vector<Observer> obs = new Vector<Observer>(); 
	
	
	public ArrayList<Bahnhof> getBahnhoefe() 
	{
		return bahnhoefe;
	}
	public void addBahnhof(Bahnhof bahnhof)
	{
		bahnhoefe.add(bahnhof);
	}
	
	private BahnhofModel() 
	{
		
	}
	public static BahnhofModel getInstens ()
	{
		if(ob == null)
		{
			ob  = new BahnhofModel();
		}
		return ob;
	}
	public void schreibeBahnhofInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.csv", true));
			for (Bahnhof bahnhof : bahnhoefe) 
			{
				aus.write(bahnhof.getName());
				aus.newLine();
				aus.write(bahnhof.getOrt());
				aus.newLine();
				aus.write(bahnhof.getAnzahlGleise());
				aus.newLine();
				aus.write(bahnhof.getLetzteRenovierung());
				aus.newLine();
				aus.write(bahnhof.getZugartenAlsString('_'));
				aus.newLine();
			}
			aus.close();
	}
	public void leseAusDatei(String typ) throws IOException{
      		
		Creator creator = new ConcreteCreatorA();
	 	Product product = creator.factoryMethod();
	 	
	 	String [] zeile = product.leseAusDatei();
	 	
      			bahnhoefe.add( new Bahnhof(
      										zeile[0],
      										zeile[1],
      										Integer.parseInt(zeile[2]),
      					Integer.parseInt(zeile[3]), zeile[4].split("_")));

      			product.schliesseDatei();

	}
	public void leseAusDateiTxt() throws IOException
	{
  		
	Creator creator = new ConcreteCreatorB();
 	Product product = creator.factoryMethod();
 	
 	String [] zeile = product.leseAusDatei();
 		
  			bahnhoefe.add(new Bahnhof(
  										zeile[0],
  										zeile[1],
  										Integer.parseInt(zeile[2]),
  					Integer.parseInt(zeile[3]), zeile[4].split("_")));
  			
  			product.schliesseDatei();
	}
	@Override
	public void addObserver(Observer obs) 
	{
		this.obs.add(obs);
	}
	@Override
	public void removeObserver(Observer obs) 
	{
		this.obs.remove(obs);
		
	}
	@Override
	public void notifyObservers() {
		for (Observer observer : obs) 
		{
			observer.update();
		}
		
	}
}
