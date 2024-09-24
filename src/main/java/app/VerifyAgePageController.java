package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.ParseException;

public class VerifyAgePageController {
    @FXML
    Button submitButton;
    @FXML
    TextField textInput;
    @FXML
    Text responseText;

    public void submit() {
        try {
            int age = Integer.parseInt(textInput.getText());
            if (age < 18) {
                responseText.setText("you are too young");
            } else {
                responseText.setText("alright let's get started");
            }
        } catch (NumberFormatException nfe) {
            responseText.setText("That is not a number");
        }
    }
}
