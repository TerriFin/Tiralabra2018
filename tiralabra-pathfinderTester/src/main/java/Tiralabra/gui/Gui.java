package Tiralabra.gui;

import Tiralabra.domain.BreadthFirstSearch;
import Tiralabra.domain.LabyrinthGenerator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui {
    
    private static BorderPane root;
    public static Scene mainScene;
    
    public Gui(double screenWidth, double screenHeight) {
        this.root = new BorderPane();
        this.mainScene = new Scene(this.root, screenWidth, screenHeight);
    }
    
    public static void generateNewMainScene(int labyrinthSize) {
        Double screenWidth = mainScene.getWidth();
        Double screenHeight = mainScene.getHeight();
        
        root.setTop(LabyrinthDrawer.drawLabyrinth(LabyrinthGenerator.generateLabyrinth(labyrinthSize), screenWidth.intValue(), screenHeight.intValue()));
        root.setBottom(UserIO.getUserIO());
        
        BreadthFirstSearch test = new BreadthFirstSearch(LabyrinthGenerator.generateLabyrinth(labyrinthSize));
        root.setTop(LabyrinthDrawer.drawLabyrinth(test.getLabyrinth(), screenWidth.intValue(), screenHeight.intValue()));
    }
}
