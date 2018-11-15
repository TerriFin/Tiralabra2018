package Tiralabra.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    
    private Label breadthSteps = new Label("0");
    private Label breadthPath = new Label("0");
    
    private Label depthSteps = new Label("0");
    private Label depthPath = new Label("0");
    
    private Label starSteps = new Label("0");
    private Label starPath = new Label("0");
    
    public void updateBreath(int newSteps, int newPath) {
        breadthSteps.setText(newSteps + "");
        breadthPath.setText(newPath + "");
    }
    
    public void updateDepth(int newSteps, int newPath) {
        depthSteps.setText(newSteps + "");
        depthPath.setText(newPath + "");
    }
    
    public void updateStar(int newSteps, int newPath) {
        starSteps.setText(newSteps + "");
        starPath.setText(newPath + "");
    }

    /**
     * Gives a HBox-node that contains all that is needed for inputs during processing.
     *
     * @param gui reference to the gui that called this, needed for gaining access to generating new main scenes
     * @param animator reference to the animator in the gui, needed to stop the old animations when new main scene is generated
     * @return HBox-node that contains all that is needed for input during processing.
     */
    public HBox getUserInput(Gui gui, LabyrinthAnimator animator) {
        HBox root = new HBox();

        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(30);
        
        
        VBox breathBox = new VBox();
        HBox breathStepsBox = new HBox();
        HBox breathPathBox = new HBox();
        
        Label breadthStepsLabel = new Label("Breadth-first steps: ");
        Label breadthPathLabel = new Label("Breadth-first path length: ");
        
        breathStepsBox.getChildren().addAll(breadthStepsLabel, breadthSteps);
        breathPathBox.getChildren().addAll(breadthPathLabel, breadthPath);
        breathBox.getChildren().addAll(breathStepsBox, breathPathBox);
        
        
        VBox depthBox = new VBox();
        HBox depthStepsBox = new HBox();
        HBox depthPathBox = new HBox();
        
        Label depthStepsLabel = new Label("Depth-first steps: ");
        Label depthPathLabel = new Label("Depth-first path length: ");
        
        depthStepsBox.getChildren().addAll(depthStepsLabel, depthSteps);
        depthPathBox.getChildren().addAll(depthPathLabel, depthPath);
        depthBox.getChildren().addAll(depthStepsBox, depthPathBox);
        
        
        VBox starBox = new VBox();
        HBox starStepsBox = new HBox();
        HBox starPathBox = new HBox();
        
        Label starStepsLabel = new Label("A* steps: ");
        Label starPathLabel = new Label("A* path length: ");
        
        starStepsBox.getChildren().addAll(starStepsLabel, starSteps);
        starPathBox.getChildren().addAll(starPathLabel, starPath);
        starBox.getChildren().addAll(starStepsBox, starPathBox);
        
        
        root.getChildren().addAll(breathBox, depthBox, starBox);
        

        Label labyrinthSizeInputLabel = new Label("Enter new labyrinth size:");
        TextField newLabyrinthSizeInput = new TextField();
        Button generateButton = new Button();
        generateButton.setText("Generate");
        generateButton.setOnAction((ActionEvent event) -> {
            animator.stop();
            gui.generateNewMainScene(Integer.parseInt(newLabyrinthSizeInput.getText()));
        });

        root.getChildren().addAll(labyrinthSizeInputLabel, newLabyrinthSizeInput, generateButton);
        return root;
    }
}
