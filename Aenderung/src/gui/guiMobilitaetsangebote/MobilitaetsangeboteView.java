package gui.guiMobilitaetsangebote;
import business.Bahnhof;
import business.BahnhofModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class MobilitaetsangeboteView {
	
private MobilitaetsangeboteControl
 	mobilitaetsangeboteControl;
private BahnhofModel bahnhofModel;

    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBahnhoefe     
 		= new Label("Anzeige Bahnh�fe");
    	private TextArea txtAnzeigeBahnhoefe  = new TextArea();
    	private Button btnAnzeigeBahnhoefe = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public MobilitaetsangeboteView(
 		MobilitaetsangeboteControl 
 		MobilitaetsangeboteControl, 
   	 	Stage primaryStage, 
 		BahnhofModel bahnhofModel){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von Mobilit�tsangeboten");
    		primaryStage.show();
    		this.mobilitaetsangeboteControl 
 			= mobilitaetsangeboteControl;
 		this.bahnhofModel = bahnhofModel;
 		this.initKomponenten();
		this.initListener();
    	}

 	private void initKomponenten(){
    		// Label
 		Font font = new Font("Arial", 20);
       	lblAnzeigeBahnhoefe.setLayoutX(310);
    		lblAnzeigeBahnhoefe.setLayoutY(40);
    		lblAnzeigeBahnhoefe.setFont(font);
    		lblAnzeigeBahnhoefe.setStyle("-fx-font-weight: bold;"); 
       	pane.getChildren().add(lblAnzeigeBahnhoefe);           
// Textbereich	
        	txtAnzeigeBahnhoefe.setEditable(false);
     		txtAnzeigeBahnhoefe.setLayoutX(310);
    		txtAnzeigeBahnhoefe.setLayoutY(90);
     		txtAnzeigeBahnhoefe.setPrefWidth(220);
    		txtAnzeigeBahnhoefe.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeigeBahnhoefe);        	
        	// Button
          	btnAnzeigeBahnhoefe.setLayoutX(310);
        	btnAnzeigeBahnhoefe.setLayoutY(290);
        	pane.getChildren().add(btnAnzeigeBahnhoefe); 
   }
   
   private void initListener() {
	    btnAnzeigeBahnhoefe.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBahnhofAn();
	        	} 
   	    });
    }
   
   void zeigeBahnhofAn(){
  	 if(bahnhofModel.getBanhoefe().size() > 0){ 
  	       StringBuffer text = new StringBuffer(); 
  	    // Ergaenzen: for each – Schleife ueber ArrayList 
  	        for (Bahnhof bahnhof : bahnhofModel.getBanhoefe()) 
  	        {
					text.append(bahnhof.gibBahnhofZurueck(' ') + "\n"); 
				}
  	        	this.txtAnzeigeBahnhoefe.setText(text.toString()); 
  	      } 
  	      else
  	      { 
  	    	  zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!"); 
  	      } 
  }  	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}
