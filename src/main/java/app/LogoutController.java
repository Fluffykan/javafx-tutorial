package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LogoutController {
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    private Stage stage;

    public void logout(ActionEvent event) {
        // create an alert to confirm if user wants to logout
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm logout?");
        alert.setHeaderText("You're about to logout");
        alert.setContentText("Do you want to save before exiting?");

        // checks what button the user pressed
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("Logging out");
            stage.close();
        }


    }
}
