package app.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceBoxDemo implements Initializable {
    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> dropdown;
    private String[] food = {"Pizza", "Fish", "Pineapple"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // this is used to populate the choicebox after it is initialised
        dropdown.getItems().addAll(food);
        dropdown.setOnAction(this::getFood);
    }

    public void getFood(ActionEvent event) {
        String thisFood = dropdown.getValue();
        myLabel.setText(thisFood);
    }

}
