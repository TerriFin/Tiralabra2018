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

    private BorderPane root;
    private LabyrinthAnimator animator;

    public Scene mainScene;

    /**
     * 
     * @param screenWidth primaryStage width
     * @param screenHeight  primaryStage height
     */
    public Gui(double screenWidth, double screenHeight) {
        this.root = new BorderPane();
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

        animator = new LabyrinthAnimator(new SolverManager(labyrinth), this);

        root.setBottom(UserIO.getUserInput(this, animator));

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

        root.setCenter(LabyrinthDrawer.drawLabyrinth(labyrinth, screenWidth.intValue(), screenHeight.intValue()));
    }
}
