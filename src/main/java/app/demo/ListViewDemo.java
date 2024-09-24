package app.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewDemo implements Initializable {

    @FXML
    ListView<String> listView;
    @FXML
    Label label;

    String[] food = {"Salmon", "Cheezos", "Pizza"};
    String currentFood;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        listView.getItems().addAll(food);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentFood = listView.getSelectionModel().getSelectedItem();
                label.setText(currentFood);
            }
        });
    }
}
