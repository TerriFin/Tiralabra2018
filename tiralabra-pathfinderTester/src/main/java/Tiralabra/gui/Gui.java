package Tiralabra.gui;

import Tiralabra.domain.LabyrinthGenerator;
import Tiralabra.domain.Node;
import Tiralabra.domain.SolverManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * GraphicalUserInterface starter for the project, 
 * just create an instance and feed it primary stage resolutions.
 * 
 * @author samisaukkonen
 */
public class Gui {

    private final BorderPane root;
    private final LabyrinthDrawer drawer;

    public Scene mainScene;

    /**
     * @param screenWidth primaryStage width
     * @param screenHeight  primaryStage height
     */
    public Gui(double screenWidth, double screenHeight) {
        this.root = new BorderPane();
        this.drawer = new LabyrinthDrawer();
        
        this.mainScene = new Scene(this.root, screenWidth, screenHeight);
    }

    /**
     * Generates a new square labyrinth with given dimension, after that sets up
     * the graphical output by setting up visible labyrinth and user input, after that
     * it starts the animator that starts doing its thing until a new labyrinth is generated, or the animator finishes.
     * 
     * @param labyrinthSize Size you want the first labyrinth to be
     */
    public void generateNewMainScene(int labyrinthSize) {
        Node[][] labyrinth = LabyrinthGenerator.generateLabyrinth(labyrinthSize);
        setNewLabyrinth(labyrinth);
        
        UserIO io = new UserIO();
        
        LabyrinthAnimator animator = new LabyrinthAnimator(labyrinth, io, this);

        root.setBottom(io.getUserInput(this, animator));

        animator.startAnimation();
    }

    /**
     * Places a new labyrinth in the place of the old one, colors nodes accordingly
     * Needed for UserIO and LabyrinthAnimator
     * 
     * @param labyrinth new labyrinth, color values found in LabyrinthDrawer
     */
    public void setNewLabyrinth(Node[][] labyrinth) {
        Double screenWidth = mainScene.getWidth();
        Double screenHeight = mainScene.getHeight();

        root.setCenter(drawer.setLabyrinth(labyrinth, screenWidth.intValue(), screenHeight.intValue()));
    }
    /**
     * Updates only the previously updated node, current node and its surrounding nodes.
     * 
     * @param labyrinth labyrinth from which surrounding nodes are taken
     * @param node node to be updated, also updates surrounding nodes and the previously updated node
     */
    public void updateLabyrinth(Node[][] labyrinth, Node node) {
        Double screenWidth = mainScene.getWidth();
        Double screenHeight = mainScene.getHeight();

        root.setCenter(drawer.updateLabyrinth(labyrinth, screenWidth.intValue(), screenHeight.intValue(), node));
    }
}
