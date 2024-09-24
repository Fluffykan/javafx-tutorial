package app.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;


public class RadioButtonDemo {
    @FXML
    private Label label;
    @FXML
    private RadioButton sushiBtn, pizzaBtn, ramenBtn;

    public void toggle(ActionEvent event) {
        if (sushiBtn.isSelected()) {
            label.setText("Sushi");
        } else if (ramenBtn.isSelected()) {
            label.setText("Ramen");
        } else {
            label.setText("Pizza");
        }
    }

}
