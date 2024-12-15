package business;

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
	private ArrayList<Bahnhof> banhoefe = new ArrayList<Bahnhof>();
	private static BahnhofModel ob;
	private Vector<Observer> obs = new Vector<Observer>(); 
	
	

	private BahnhofModel() 
	{
		
	}
	
	public ArrayList<Bahnhof> getBanhoefe() 
	{
		return banhoefe;
	}
	
	public void addBahnhof(Bahnhof bahnhof) 
	{
		this.banhoefe.add(bahnhof);
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
			BufferedWriter aus = new BufferedWriter(new FileWriter("BahnhoefeAusgabe.txt", true));
			for (Bahnhof bahnhof : banhoefe) 
			{
				aus.write("Daten des Bahnhofs");
				aus.newLine();
				aus.write("Name des Bahnhofs: 			" + bahnhof.getName());
				aus.newLine();
				aus.write("Ort: 						" + bahnhof.getOrt());
				aus.newLine();
				aus.write("Anzahl Gleise: 				" + bahnhof.getAnzahlGleise());
				aus.newLine();
				aus.write("Letzte Renovierung: 		" + bahnhof.getLetzteRenovierung());
				aus.newLine();
				aus.write("Zugarten: 					" + bahnhof.getZugartenAlsString('_'));
				aus.newLine();
				aus.newLine();
			}
			aus.close();
	}
	public void leseAusDatei(String typ) throws IOException{
      		
		Creator creator = new ConcreteCreatorA();
	 	Product product = creator.factoryMethod();
	 	
	 	String [] zeile = product.leseAusDatei();
	 	
      			addBahnhof(new Bahnhof(
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
 		
  			addBahnhof(new Bahnhof(
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
	public void notifyObservers() 
	{
		for (Observer observer : obs) 
		{
			observer.update();
		}
		
	}
}
