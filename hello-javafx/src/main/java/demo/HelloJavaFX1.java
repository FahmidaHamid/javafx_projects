package demo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX1 extends Application {

    @Override
    public void start(Stage stage){

        Label instruction = new Label("What is your name?");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");

        Button greetButton = new Button("Say Hello");

        Label greeting = new Label();

        greetButton.setOnAction(event -> {
            String name = nameField.getText().trim();

            if (name.isEmpty()) {
                greeting.setText("Please enter your name.");
            } else {
                greeting.setText("Hello, " + name + "!");
            }

        });

        VBox layout = new VBox(12, instruction, nameField, greeting, greetButton);
        layout.setPadding(new Insets(20));
        Scene scene = new Scene(layout, 720, 440);

        stage.setTitle("My First JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}