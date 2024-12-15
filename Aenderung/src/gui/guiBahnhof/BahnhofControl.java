package gui.guiBahnhof;

import java.io.IOException;

import business.BahnhofModel;
import javafx.stage.Stage;
import ownUtil.Observer;
public class BahnhofControl implements Observer {
	private BahnhofView bv;
	private BahnhofModel bm;
	
	
	public BahnhofControl(Stage st) 
	{
		this.bm = BahnhofModel.getInstens();
		this.bv = new BahnhofView(st,this,bm);
		bm.addObserver(this);
	}
	
    public void leseAusDatei(String typ){
    	try {
    	if("csv".equals(typ))
    	{
    			bm.leseAusDatei("csv");
      	  	   	//bv.zeigeInformationsfensterAn("Die Bahnhoefe wurden gelesen!");
    	}
      		
       	else
       	{
	   		bm.leseAusDateiTxt();
	   		//bv.zeigeInformationsfensterAn("Die Bahnhoefe wurden gelesen!");
	   	}
    	}
		catch(IOException exc)
		{
			bv.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		}
		catch(Exception exc)
		{
			bv.zeigeFehlermeldungsfensterAn( "Unbekannter Fehler beim Lesen!");
		}
    
    }

		
	public void schreibeBahnhofInCsvDatei() {
		try {
			bm.schreibeBahnhofInCsvDatei();
   			bv.zeigeInformationsfensterAn("Die Bahnhoefe wurden gespeichert!");
		}	
		catch(IOException exc){
			bv.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			bv.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		bv.zeigeBahnhofAn();
		
	}
}

