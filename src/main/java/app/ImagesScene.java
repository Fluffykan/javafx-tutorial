package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagesScene {

    @FXML
    ImageView myImageView;
    Button myButton;
    Image myImage = new Image(getClass().getResourceAsStream("/images/icon.jpg"));
    Image baseImage = new Image(getClass().getResourceAsStream("/images/car.jpg"));


    public void displayImage() {
        myImageView.setImage(myImage);
    }

    public void displayBaseImage() {
        myImageView.setImage(baseImage);
    }
}
