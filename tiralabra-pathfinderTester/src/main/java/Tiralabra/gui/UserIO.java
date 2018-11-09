package Tiralabra.gui;

import Tiralabra.domain.Node;
import Tiralabra.domain.SolverManager;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class UserIO {
    public static HBox getUserIO(Gui gui, LabyrinthAnimator animator) {
        HBox root = new HBox();
        
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        
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
