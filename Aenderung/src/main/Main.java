package main;


import gui.guiBahnhof.BahnhofControl;
import gui.guiMobilitaetsangebote.MobilitaetsangeboteControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) 
	{
		new BahnhofControl(primaryStage);
		Stage fensterMobilitaetsangeboteStage = new Stage();
		new MobilitaetsangeboteControl(fensterMobilitaetsangeboteStage);
	}	
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
