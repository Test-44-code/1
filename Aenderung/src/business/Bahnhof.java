package business;

public class Bahnhof {
	
    private String name;
    private String ort;
    private int anzahlGleise;
    private int letzteRenovierung;
    private String[] zugArten;

    public Bahnhof(String name, String ort, int anzahlGleise,
    	int letzteRenovierung, String[] zugarten){
   		this.name = name;
  	    this.ort = ort;
   	    this.anzahlGleise = anzahlGleise;
   	    this.letzteRenovierung = letzteRenovierung;
   	    this.zugArten = zugarten;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	public void setAnzahlGleise(int anzahlGleise) {
		this.anzahlGleise = anzahlGleise;
	}

	public int getLetzteRenovierung() {
		return letzteRenovierung;
	}

	public void setLetzteRenovierung(int letzteRenovierung) {
		this.letzteRenovierung = letzteRenovierung;
	}

	public String[] getZugArten() {
		return zugArten;
	}

	public void setZugArten(String[] zugArten) {
		this.zugArten = zugArten;
	}

	public String getZugartenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getZugArten().length - 1; i++) {
			ergebnis = ergebnis + this.getZugArten()[i] + trenner; 
		}
		return ergebnis	+ this.getZugArten()[i];
	}
	
	public String gibBahnhofZurueck(char trenner){
  		return this.getName() + trenner 
  			+ this.getOrt() + trenner
  		    + this.getAnzahlGleise() + trenner
  		    + this.getLetzteRenovierung() + trenner + "\n"
  		    + this.getZugartenAlsString(trenner) + "\n";
  	}
}

