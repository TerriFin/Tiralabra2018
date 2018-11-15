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

    private double lastSceneWidth;
    private double lastSceneHeight;
    private Node lastChanged;

    private GridPane root;

    /**
     * Draws a labyrinth based on parameters given to it, each node has a .value
     * modifier, which determines the color of the cell in the labyrinth. The
     * colors go as follows;
     *
     * 0 - White - Open space 1 - Black - Wall 2 - Green - Node that has been
     * processed 3 - GreenYellow - Node that is waiting to be processed 4 -
     * Yellow - Node currently being processed 5 - Red - Goal 6 - Magenta -
     * Found path
     *
     * @param labyrinth the labyrinth that is going to be drawn
     * @param sceneWidth current screen width, the labyrinth is going to be
     * sized appropriately
     * @param sceneHeight current screen height, the labyrinth is going to be
     * sized appropriately
     * @return Returns a GridPane containing the labyrinth adjusted for the
     * current window size.
     */
    public GridPane setLabyrinth(Node[][] labyrinth, int sceneWidth, int sceneHeight) {
        lastSceneWidth = sceneWidth;
        lastSceneHeight = sceneHeight;
        lastChanged = null;

        root = new GridPane();

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));

        double rectangleWidth = (sceneWidth / labyrinth.length) * 0.75;
        double rectangleHeight = (sceneHeight / labyrinth[0].length) * 0.75;
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[0].length; y++) {
                root.add(createRectangle(labyrinth[x][y], rectangleWidth, rectangleHeight), x, y);
            }
        }

        return root;
    }

    public GridPane updateLabyrinth(Node[][] labyrinth, int sceneWidth, int sceneHeight, Node toUpdate) {
        if (lastSceneWidth != sceneWidth) {
            lastSceneWidth = sceneWidth;
            lastSceneHeight = sceneHeight;
            
            return setLabyrinth(labyrinth, sceneWidth, sceneHeight);
        } else if (lastSceneHeight != sceneHeight) {
            lastSceneWidth = sceneWidth;
            lastSceneHeight = sceneHeight;
            
            return setLabyrinth(labyrinth, sceneWidth, sceneHeight);
        } else {
            double rectangleWidth = (sceneWidth / labyrinth.length) * 0.75;
            double rectangleHeight = (sceneHeight / labyrinth[0].length) * 0.75;

            root.add(createRectangle(toUpdate, rectangleWidth, rectangleHeight), toUpdate.x, toUpdate.y);
            root.add(createRectangle(labyrinth[toUpdate.x + 1][toUpdate.y], rectangleWidth, rectangleHeight), toUpdate.x + 1, toUpdate.y);
            root.add(createRectangle(labyrinth[toUpdate.x - 1][toUpdate.y], rectangleWidth, rectangleHeight), toUpdate.x - 1, toUpdate.y);
            root.add(createRectangle(labyrinth[toUpdate.x][toUpdate.y + 1], rectangleWidth, rectangleHeight), toUpdate.x, toUpdate.y + 1);
            root.add(createRectangle(labyrinth[toUpdate.x][toUpdate.y - 1], rectangleWidth, rectangleHeight), toUpdate.x, toUpdate.y - 1);
            
            if (lastChanged != null) {
                root.add(createRectangle(lastChanged, rectangleWidth, rectangleHeight), lastChanged.x, lastChanged.y);
            }
            
            lastChanged = toUpdate;

            return root;
        }
    }

    private Rectangle createRectangle(Node node, double rectangleWidth, double rectangleHeight) {
        Rectangle rec = new Rectangle();
        rec.setWidth(rectangleWidth);
        rec.setHeight(rectangleHeight);

        switch (node.value) {
            case 0:
                rec.setFill(Color.WHITE);
                break;
            case 1:
                rec.setFill(Color.BLACK);
                break;
            case 2:
                rec.setFill(Color.GREEN);
                break;
            case 3:
                rec.setFill(Color.GREENYELLOW);
                break;
            case 4:
                rec.setFill(Color.YELLOW);
                break;
            case 5:
                rec.setFill(Color.RED);
                break;
            case 6:
                rec.setFill(Color.MAGENTA);
                break;
            default:
                break;
        }

        return rec;
    }
}
