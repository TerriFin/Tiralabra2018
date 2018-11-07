package Tiralabra.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class UserIO {
    public static HBox getUserIO() {
        HBox root = new HBox();
        
        root.setAlignment(Pos.BASELINE_CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        Label labyrinthSizeInputLabel = new Label("Enter new labyrinth size:");
        TextField newLabyrinthSizeInput = new TextField();
        Button button = new Button();
        button.setText("Generate");
        button.setOnAction((ActionEvent event) -> {
            Gui.generateNewMainScene(Integer.parseInt(newLabyrinthSizeInput.getText()));
        });
        
        root.getChildren().addAll(labyrinthSizeInputLabel, newLabyrinthSizeInput, button);
        return root;
    }
}
