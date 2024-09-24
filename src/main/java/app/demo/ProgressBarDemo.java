package app.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgressBarDemo implements Initializable {

    @FXML
    Label label;
    @FXML
    ProgressBar progressBar;
    @FXML
    Button start;

    // Big decimal used to control rounding, bcos rounding will be inaccurate after many additions
    BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        progressBar.setStyle("-fx-accent: red;");
    }

    public void increaseProgress() {
        if (progress.doubleValue() >= 1) {
            return;
        }
        progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + 0.1));
        progressBar.setProgress(progress.doubleValue());
        label.setText((int) (progress.doubleValue() * 100) + "%");
    }
}
