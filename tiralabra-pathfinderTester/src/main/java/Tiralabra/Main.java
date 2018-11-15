package Tiralabra;

import Tiralabra.gui.Gui;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("PathFinderTesterThingy");
        primaryStage.setWidth(640);
        primaryStage.setHeight(400);
        
        Gui mainGui = new Gui(primaryStage.getWidth(), primaryStage.getHeight());
        mainGui.generateNewMainScene(15);
        primaryStage.setScene(mainGui.mainScene);
        

        primaryStage.show();
    }
    
}
