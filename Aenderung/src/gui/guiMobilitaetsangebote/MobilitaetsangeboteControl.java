package gui.guiMobilitaetsangebote;

import business.BahnhofModel;
import javafx.stage.Stage;
import ownUtil.Observer;
public class MobilitaetsangeboteControl implements Observer {	
	private MobilitaetsangeboteView mobilitaetsangeboteView;
	private BahnhofModel bahnhoefeModel;
	
	public MobilitaetsangeboteControl(Stage primaryStage)
	{
 		this.bahnhoefeModel = bahnhoefeModel.getInstens(); 		
		this.mobilitaetsangeboteView = new MobilitaetsangeboteView(this, primaryStage,bahnhoefeModel);
		bahnhoefeModel.addObserver(this);
	}

	@Override
	public void update() {
		mobilitaetsangeboteView.zeigeBahnhofAn();
		
	}
}

