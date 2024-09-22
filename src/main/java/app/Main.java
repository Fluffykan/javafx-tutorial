package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.awt.*;

public class Main extends Application {
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        customiseStage(primaryStage);

        // scenesDemo(primaryStage)
         loadSceneFromFxml(primaryStage);

        // displays the stage
        primaryStage.show();
    }

    private void loadSceneFromFxml(Stage primaryStage) throws Exception {
        // replace string with FXML file destination
        Parent root = FXMLLoader.load(getClass().getResource("/view/Controller.fxml"));
        primaryStage.setScene(new Scene(root));
    }

    private void scenesDemo(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        primaryStage.setScene(scene);

        Text text = new Text();
        customizeText(text);

        Line line = new Line();
        customizeLine(line);

        Rectangle rectangle = new Rectangle();
        customiseRectangle(rectangle);

        Polygon triangle = new Polygon();
        customiseTriangle(triangle);

        Circle circle = new Circle();
        customiseCircle(circle);

        Image image = new Image("/images/icon.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);

        root.getChildren().addAll(text, line, rectangle, triangle, circle, imageView);

    }

    private void customiseCircle(Circle circle) {
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);
    }

    private void customiseTriangle(Polygon triangle) {
        triangle.getPoints().setAll(
                200.0, 200.0,
                300.0, 300.0,
                200.0, 200.0
        );

        triangle.setFill(Color.YELLOW);
    }

    private void customiseRectangle(Rectangle rectangle) {
        // set the position of the rectangle
        rectangle.setX(100);
        rectangle.setY(100);

        // set the width and height of the rectangle
        rectangle.setWidth(100);
        rectangle.setHeight(100);

        // set the fill color of the rectangle
        rectangle.setFill(Color.BLUE);

        // set the border width and color of the rectangle
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.WHITE);

        // also has setOpacity and setRotate methods
    }

    private void customizeLine(Line line) {
        // set the coordinates that the line starts from and ends at
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);

        // set the thickness of the line
        line.setStrokeWidth(5);

        // set the color of the line
        line.setStroke(Color.RED);

        // set the opacity of the line (0 <= x <= 1)
        line.setOpacity(0.5);

        // rotate the line
        line.setRotate(45);
    }

    private void customizeText(Text text) {
        text.setText("wow");

        // set the location of the text
        text.setX(50);
        text.setY(50);

        // set the font and font size
        text.setFont(Font.font("verdana", 50));

        // set the font color
        text.setFill(Color.LIMEGREEN);
    }

    private void customiseStage(Stage primaryStage) {
        // this sets the string at the top of the window
        primaryStage.setTitle("Window title");
        // this sets the icon at the top of the window
        Image icon =  new Image("/images/icon.jpg");
        primaryStage.getIcons().add(icon);

        // this sets the size of the stage on launch
        // primaryStage.setHeight(420);
        // primaryStage.setWidth(420);

        // this disables resizing
        // primaryStage.setResizable(false);

        // this sets where the window appears on the screen by default
        // primaryStage.setX(50);
        // primaryStage.setY(50);

        // this sets the window to appear on fullscreen mode by default
        // +primaryStage.setFullScreen(true);

        // this sets the message displayed when the app is in fullscreen
        // primaryStage.setFullScreenExitHint("exit fullscreen using q");
        // this sets the key used to exit fullscreen
        // primaryStage.setFullScreenExitKeyCombination(KeyCombination.keyCombination("q"));
    }
}
