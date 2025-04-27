package module7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a Pane to hold the circles
        Pane pane = new Pane();

        // Circle 1: White fill, black stroke (class styling)
        Circle circle1 = new Circle(100, 100, 50);
        circle1.getStyleClass().add("white-fill-black-stroke");

        // Circle 2: White fill, black stroke (class styling)
        Circle circle2 = new Circle(250, 100, 50);
        circle2.getStyleClass().add("white-fill-black-stroke");

        // Circle 3: Red fill (ID styling)
        Circle circle3 = new Circle(100, 250, 50);
        circle3.setId("red-circle");

        // Circle 4: Green fill (ID styling)
        Circle circle4 = new Circle(250, 250, 50);
        circle4.setId("green-circle");

        // Add circles to the Pane
        pane.getChildren().addAll(circle1, circle2, circle3, circle4);

        // Create a Scene and attach the CSS file
        Scene scene = new Scene(pane, 400, 400);
        scene.getStylesheets().add(getClass().getResource("mystyle.css").toExternalForm());

        // Set up the Stage
        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}