package app.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SpinnerDemo implements Initializable {

    @FXML
    Spinner<Integer> spinner;
    @FXML
    Label label;

    int currentVal;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // creates a value factory which is what values the spinner can possess
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);

        // adds the value factory to the spinner
        spinner.setValueFactory(valueFactory);

        currentVal = spinner.getValue();

        label.setText(Integer.toString(currentVal));

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                currentVal = spinner.getValue();
                label.setText(Integer.toString(currentVal));
            }
        });
    }


}
