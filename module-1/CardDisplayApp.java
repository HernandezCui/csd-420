import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardDisplayApp extends Application {
    private static final int TOTAL_CARDS = 52;
    private static final String CARDS_DIRECTORY = "AssignmentCards";  // Directory where images are stored
    private List<ImageView> imageViews = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        // container to hold images
        HBox imageContainer = new HBox(10);

        // Initialize image views for four cards
        for (int i = 0; i < 4; i++) {
            imageViews.add(new ImageView());
        }

        // refresh button
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(e -> refreshImages());  // Lambda expression for event handling

        // Add image views and refresh button to the layout
        imageContainer.getChildren().addAll(imageViews);
        HBox root = new HBox(10, imageContainer, refreshButton);

        // Set up the scene and stage
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("Card Display");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initial image display
        refreshImages();
    }

    private void refreshImages() {
        // Clear previous images
        for (ImageView imageView : imageViews) {
            imageView.setImage(null);
        }

        // Get random card indices
        List<Integer> cardIndices = generateRandomIndices();

        // Load and display images for the randomly selected cards
        for (int i = 0; i < 4; i++) {
            String cardPath = CARDS_DIRECTORY + File.separator + cardIndices.get(i) + ".png";
            Image image = new Image("file:" + cardPath);
            imageViews.get(i).setImage(image);
        }
    }

    private List<Integer> generateRandomIndices() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= TOTAL_CARDS; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);  // Shuffle to randomize the list
        return indices.subList(0, 4);  // Get the first 4 random indices
    }
}