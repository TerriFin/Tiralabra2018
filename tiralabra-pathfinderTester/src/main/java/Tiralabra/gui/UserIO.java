package Tiralabra.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Generates all text-based GUI IO
 *
 * @author samisaukkonen
 */
public class UserIO {

    private Button showCompletedBreath;
    private Label breadthSteps;
    private Label breadthPath;

    private Button showCompletedDepth;
    private Label depthSteps;
    private Label depthPath;

    private Button showCompletedStar;
    private Label starSteps;
    private Label starPath;

    public UserIO() {
        this.showCompletedBreath = new Button("Show completed");
        this.showCompletedBreath.setDisable(true);
        this.breadthSteps = new Label("0");
        this.breadthPath = new Label("0");

        this.showCompletedDepth = new Button("Show completed");
        this.showCompletedDepth.setDisable(true);
        this.depthSteps = new Label("0");
        this.depthPath = new Label("0");

        this.showCompletedStar = new Button("Show completed");
        this.showCompletedStar.setDisable(true);
        this.starSteps = new Label("0");
        this.starPath = new Label("0");
    }

    /**
     * Updates breath-first related output
     *
     * @param newSteps new amount of steps used in this algorithm
     * @param newPath new path length found in this algorithm
     */
    public void updateBreath(int newSteps, int newPath) {
        breadthSteps.setText(newSteps + "");
        breadthPath.setText(newPath + "");
    }

    /**
     * Updates depth-first related output
     *
     * @param newSteps new amount of steps used in this algorithm
     * @param newPath new path length found in this algorithm
     */
    public void updateDepth(int newSteps, int newPath) {
        depthSteps.setText(newSteps + "");
        depthPath.setText(newPath + "");
    }

    /**
     * Updates aStar related output
     *
     * @param newSteps new amount of steps used in this algorithm
     * @param newPath new path length found in this algorithm
     */
    public void updateStar(int newSteps, int newPath) {
        starSteps.setText(newSteps + "");
        starPath.setText(newPath + "");
    }

    /**
     * Gives a HBox-node that contains all that is needed for inputs during
     * processing.
     *
     * @param gui reference to the gui that called this, needed for gaining
     * access to generating new main scenes
     * @param animator reference to the animator in the gui, needed to stop the
     * old animations when new main scene is generated
     * @return HBox-node that contains all that is needed for input during
     * processing.
     */
    public HBox getUserInput(Gui gui, LabyrinthAnimator animator) {
        showCompletedBreath.setOnAction(e -> {
            animator.setFinishedLabyrinthDoDrawToBreath();
        });
        
        showCompletedDepth.setOnAction(e -> {
            animator.setFinishedLabyrinthDoDrawToDepth();
        });
        
        showCompletedStar.setOnAction(e -> {
            animator.setFinishedLabyrinthDoDrawToStar();
        });
        
        HBox root = new HBox();

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setSpacing(30);

        VBox breathBox = new VBox();
        HBox breathStepsBox = new HBox();
        HBox breathPathBox = new HBox();

        Label breadthStepsLabel = new Label("Breadth-first steps: ");
        Label breadthPathLabel = new Label("Breadth-first path length: ");

        breathStepsBox.getChildren().addAll(breadthStepsLabel, breadthSteps);
        breathPathBox.getChildren().addAll(breadthPathLabel, breadthPath);
        breathBox.getChildren().addAll(showCompletedBreath, breathStepsBox, breathPathBox);

        VBox depthBox = new VBox();
        HBox depthStepsBox = new HBox();
        HBox depthPathBox = new HBox();

        Label depthStepsLabel = new Label("Depth-first steps: ");
        Label depthPathLabel = new Label("Depth-first path length: ");

        depthStepsBox.getChildren().addAll(depthStepsLabel, depthSteps);
        depthPathBox.getChildren().addAll(depthPathLabel, depthPath);
        depthBox.getChildren().addAll(showCompletedDepth, depthStepsBox, depthPathBox);

        VBox starBox = new VBox();
        HBox starStepsBox = new HBox();
        HBox starPathBox = new HBox();

        Label starStepsLabel = new Label("A* steps: ");
        Label starPathLabel = new Label("A* path length: ");

        starStepsBox.getChildren().addAll(starStepsLabel, starSteps);
        starPathBox.getChildren().addAll(starPathLabel, starPath);
        starBox.getChildren().addAll(showCompletedStar, starStepsBox, starPathBox);

        root.getChildren().addAll(breathBox, depthBox, starBox);

        VBox newLabyrinthInputContainer = new VBox(5);
        newLabyrinthInputContainer.setAlignment(Pos.CENTER_LEFT);

        Label labyrinthSizeInputLabel = new Label("Enter new labyrinth size:");
        TextField newLabyrinthSizeInput = new TextField();
        Button generateButton = new Button();
        generateButton.setText("Generate");
        generateButton.setOnAction((ActionEvent event) -> {
            try {
                int newLabyrinthSize = Integer.parseInt(newLabyrinthSizeInput.getText());
                if (newLabyrinthSize < 5 || newLabyrinthSize > 120) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a value between 5 and 120.");
                    alert.showAndWait();
                } else {
                    animator.stop();
                    gui.generateNewMainScene(Integer.parseInt(newLabyrinthSizeInput.getText()));
                }
            } catch (Exception exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please use only numbers.");
                alert.showAndWait();
            }
        });

        newLabyrinthInputContainer.getChildren().addAll(labyrinthSizeInputLabel, newLabyrinthSizeInput, generateButton);

        root.getChildren().add(newLabyrinthInputContainer);
        return root;
    }
    
    public void activateCompletedLabyrinthsButtons() {
        showCompletedBreath.setDisable(false);
        showCompletedDepth.setDisable(false);
        showCompletedStar.setDisable(false);
    }
}
