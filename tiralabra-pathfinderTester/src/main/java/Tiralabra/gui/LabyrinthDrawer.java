package Tiralabra.gui;

import Tiralabra.domain.Node;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * All things related to drawing labyrinths
 * 
 * @author samisaukkonen
 */
public class LabyrinthDrawer {
    
    /**
     * Draws a labyrinth based on parameters given to it, each node has a .value modifier, 
     * which determines the color of the cell in the labyrinth. The colors go as follows;
     * 
     * 0 - White - Open space
     * 1 - Black - Wall
     * 2 - Green - Node that has been processed
     * 3 - GreenYellow - Node that is waiting to be processed
     * 4 - Yellow - Node currently being processed
     * 5 - Red - Goal
     * 6 - Magenta - Found path
     * 
     * @param labyrinth the labyrinth that is going to be drawn
     * @param sceneWidth current screen width, the labyrinth is going to be sized appropriately
     * @param sceneHeight current screen height, the labyrinth is going to be sized appropriately
     * @return Returns a GridPane containing the labyrinth adjusted for the current window size.
     */
    public static GridPane drawLabyrinth(Node[][] labyrinth, int sceneWidth, int sceneHeight) {
        GridPane root = new GridPane();
        
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        double rectangleWidth = (sceneWidth / labyrinth.length) * 0.75;
        double rectangleHeight = (sceneHeight / labyrinth[0].length) * 0.75;
        
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[0].length; y++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(rectangleWidth);
                rec.setHeight(rectangleHeight);
                
                if (labyrinth[x][y].value == 0) {
                    rec.setFill(Color.WHITE);
                } else if (labyrinth[x][y].value == 1) {
                    rec.setFill(Color.BLACK);
                } else if (labyrinth[x][y].value == 2) {
                    rec.setFill(Color.GREEN);
                } else if (labyrinth[x][y].value == 3) {
                    rec.setFill(Color.GREENYELLOW);
                } else if (labyrinth[x][y].value == 4) {
                    rec.setFill(Color.YELLOW);
                } else if (labyrinth[x][y].value == 5) {
                    rec.setFill(Color.RED);
                } else if (labyrinth[x][y].value == 6) {
                    rec.setFill(Color.MAGENTA);
                }
                
                root.add(rec, x, y);
            }
        }

        return root;
    }
}
