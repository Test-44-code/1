package business;

import java.util.ArrayList;

public class Bahnhof {
	
    private String name;
    private String ort;
    private int anzahlGleise;
    private int letzteRenovierung;
    private ArrayList<String> zugArten;

    public Bahnhof(String name, String ort, int anzahlGleise,
    	int letzteRenovierung, String[] zugarten){
    	if(zugarten==(null))
    	{
    		throw new IllegalArgumentException();
    	}
   		this.name = name;
  	    this.ort = ort;
   	    this.anzahlGleise = anzahlGleise;
   	    this.letzteRenovierung = letzteRenovierung;
   	    setZugartenAusStringArray(zugarten);
    }
    
    private void setZugartenAusStringArray(String [] zugarten)
    {
    		this.zugArten = new ArrayList <String>();
    		for (int i = 0; i < zugarten.length; i++) 
    		{
				zugArten.add(zugarten[i]);
			}
    }
    
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getAnzahlGleise() {
		return anzahlGleise;
	}

	public void setAnzahlGleise(int anzahlGleise) 
	{
		this.anzahlGleise = anzahlGleise;
	}

	public int getLetzteRenovierung() {
		return letzteRenovierung;
	}

	public void setLetzteRenovierung(int letzteRenovierung) {
		this.letzteRenovierung = letzteRenovierung;
	}

	
	public ArrayList<String> getZugArten()
	{
		return zugArten;
	}

	public void setZugArten(ArrayList<String> zugArten) 
	{
		this.zugArten = zugArten;
	}

	public String getZugartenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getZugArten().size(); i++) {
			ergebnis = ergebnis + this.getZugArten().get(i) + trenner; 
		}
		return ergebnis;
	}
	
	public String gibBahnhofZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getAnzahlGleise() + trenner
  		    + this.getLetzteRenovierung() + trenner + "\n"
  		    + this.getZugartenAlsString(trenner) + "\n";
  	}
}

