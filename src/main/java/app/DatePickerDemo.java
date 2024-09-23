package app;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerDemo {
    @FXML
    DatePicker datePicker;
    @FXML
    Label label;

    public void getDate() {
        LocalDate date = datePicker.getValue();
        String dateString = date.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        label.setText(dateString);
    }
}
