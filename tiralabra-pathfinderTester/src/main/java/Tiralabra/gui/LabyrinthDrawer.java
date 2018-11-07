package Tiralabra.gui;

import Tiralabra.domain.Node;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LabyrinthDrawer {
    public static GridPane drawLabyrinth(Node[][] labyrinth, int sceneWidth, int sceneHeight) {
        GridPane root = new GridPane();
        
        double rectangleWidth = sceneWidth / labyrinth.length;
        double rectangleHeight = sceneHeight / labyrinth[0].length;
        
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[0].length; y++) {
                Rectangle rec = new Rectangle();
                rec.setWidth(rectangleWidth);
                rec.setHeight(rectangleHeight * 0.75);
                
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
                } else if (labyrinth[x][y].value == 6) {
                    rec.setFill(Color.MAGENTA);
                } else {
                    rec.setFill(Color.RED);
                }
                
                root.add(rec, x, y);
                GridPane.setHgrow(rec, Priority.ALWAYS);
            }
        }

        return root;
    }
}
