import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

import java.awt.*;

public class DialogBox extends HBox {
    private Label text;
    private ImageView displayPicture;

    public DialogBox(String s, Image i) {
        text = new Label(s);
        displayPicture = new ImageView(i);

        // Styling
        text.setWrapText(true);
        displayPicture.setFitWidth(100.0);
        displayPicture.setFitHeight(100.0);
        this.setAlignment(Pos.TOP_RIGHT);

        this.getChildren().addAll(text, displayPicture);
    }

    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    public DialogBox clipImageCircle() {
        // DOES NOT WORK FOR NOW

        //@@author Miss Chanandler Bong -reused
        // source: https://stackoverflow.com/questions/68631386/javafx-crop-image-as-a-circle
        // the method of clipping an image using a circle is reused
        double height = displayPicture.getImage().getHeight();
        double width = displayPicture.getImage().getWidth();
        Circle clip = new Circle(width / 3, height / 3, Math.min(height, width) / 3);
        displayPicture.setClip(clip);
        //@@author
        return this;
    }

    public DialogBox setBgColor(String s) {
        //@@author Sirish V -reused
        // source: https://stackoverflow.com/questions/22614758/issue-with-background-color-in-javafx-8
        this.setStyle("-fx-background-color: #" + s);
        //@@author
        return this;
    }

    public DialogBox paddingV(int i) {
        this.setPadding(new Insets(i, 0, i, 0)); // top, right, btm, left
        return this;
    }

    public DialogBox paddingH(int i) {
        this.setPadding(new Insets(0, i, 0, i)); // top, right, btm, left
        return this;
    }

    public DialogBox padding(int i) {
        this.setPadding(new Insets(i, i, i, i)); // top, right, btm, left
        return this;
    }

    public static DialogBox getUserDialog(String s, Image i) {
        return new DialogBox(s, i);
    }


    public static DialogBox getDukeDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.flip();
        return db;
    }

}

