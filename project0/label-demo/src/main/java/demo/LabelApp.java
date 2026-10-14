package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LabelApp extends Application {

    @Override
    public void start(Stage stage) {

        Label message = new Label("Welcome to CSC 220");

        StackPane layout = new StackPane(message);
        
        Scene scene = new Scene(layout, 400, 250);

        stage.setTitle("Label Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}