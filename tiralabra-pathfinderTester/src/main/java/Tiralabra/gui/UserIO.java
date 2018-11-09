package Tiralabra.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Generates all text-based GUI IO
 *
 * @author samisaukkonen
 */
public class UserIO {

    /**
     * Gives a HBox-node that contains all that is needed for inputs during processing.
     *
     * @param gui reference to the gui that called this, needed for gaining access to generating new main scenes
     * @param animator reference to the animator in the gui, needed to stop the old animations when new main scene is generated
     * @return HBox-node that contains all that is needed for input during processing.
     */
    public static HBox getUserInput(Gui gui, LabyrinthAnimator animator) {
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
