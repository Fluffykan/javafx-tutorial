package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.CheckBox;


public class CheckboxDemo {
    @FXML
    ImageView imageView;
    @FXML
    Label state;
    @FXML
    CheckBox checkBox;

    Image bulbOn = new Image(getClass().getResourceAsStream("/images/bulbOn.png"));
    Image bulbOff = new Image(getClass().getResourceAsStream("/images/bulbOff.png"));
    public void toggle(ActionEvent event) {
        if (!checkBox.isSelected()) {
            state.setText("OFF");
            imageView.setImage(bulbOff);
        } else {
            imageView.setImage(bulbOn);
            state.setText("ON");
        }
    }


}
