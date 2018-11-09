package Tiralabra.gui;

import Tiralabra.domain.PathValidator;
import Tiralabra.domain.LabyrinthGenerator;
import Tiralabra.domain.Node;
import Tiralabra.domain.SolverManager;
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

    private BorderPane root;
    private LabyrinthAnimator animator;

    public Scene mainScene;

    public Gui(double screenWidth, double screenHeight) {
        this.root = new BorderPane();
        this.mainScene = new Scene(this.root, screenWidth, screenHeight);
    }

    public void generateNewMainScene(int labyrinthSize) {
        Node[][] labyrinth = LabyrinthGenerator.generateLabyrinth(labyrinthSize);
        setNewLabyrinth(labyrinth);

        animator = new LabyrinthAnimator(new SolverManager(labyrinth), this);

        root.setBottom(UserIO.getUserIO(this, animator));

        animator.startAnimation();
    }

    public void setNewLabyrinth(Node[][] labyrinth) {
        Double screenWidth = mainScene.getWidth();
        Double screenHeight = mainScene.getHeight();

        root.setCenter(LabyrinthDrawer.drawLabyrinth(labyrinth, screenWidth.intValue(), screenHeight.intValue()));
    }
}
