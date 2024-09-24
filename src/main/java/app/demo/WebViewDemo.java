package app.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class WebViewDemo implements Initializable {
    @FXML
    WebView webView;
    @FXML
    TextField textField;
    @FXML
    Button button, refresh, history, back, fwd, execJs;
    @FXML
    Text zoomAmt;
    private final String homePage = "www.google.com";
    WebEngine engine;
    BigDecimal zoom = new BigDecimal(String.format("%.2f", 1.0));
    WebHistory webHistory;
    int currPos = 0, min = 1, max = 0;

    @Override
    public void initialize(URL arg0, ResourceBundle arg10) {
        engine = webView.getEngine();
        textField.setText(homePage);
        zoomAmt.setText("1.0x");
        load();
        back.setDisable(true);
        fwd.setDisable(true);
    }

    public void load() {
        engine.load("http://" + textField.getText());
        max = currPos += 1;
        enableDisableFwdBackBtn();
    }

    public void refresh() {
        engine.reload();
    }

    public void zoomIn() {
        zoom = new BigDecimal(String.format("%.1f", zoom.doubleValue() + 0.1));
        webView.setZoom(zoom.doubleValue());
        zoomAmt.setText(zoom + "x");
    }

    public void zoomOut() {
        zoom = new BigDecimal(String.format("%.1f", zoom.doubleValue() - 0.1));
        webView.setZoom(zoom.doubleValue());
        zoomAmt.setText(zoom + "x");
    }

    public void displayHistory() {
        webHistory = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        entries.forEach(entry -> {
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        });
    }

    public void back() {
        webHistory = engine.getHistory();
        // go() gets the current index of the entry in the list entries
        // then adds the argument to the index to get the target History object
        // it then sets the current History object to the target object
        webHistory.go(-1);
        currPos--;
        enableDisableFwdBackBtn();
    }

    public void fwd() {
        webHistory = engine.getHistory();
        webHistory.go(1);
        currPos++;
        enableDisableFwdBackBtn();
    }

    private void enableDisableFwdBackBtn() {
        System.out.println(min + " " + currPos + " " + max);
        if (currPos == max) {
            fwd.setDisable(true);
        } else {
            fwd.setDisable(false);
        }
        if (currPos == min) {
            back.setDisable(true);
        } else {
            back.setDisable(false);
        }
    }

    public void execJs() {
        engine.executeScript("window.location = \"https://www.youtube.com\";");
    }
}
