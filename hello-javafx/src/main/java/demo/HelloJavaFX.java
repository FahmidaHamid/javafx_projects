package demo;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class HelloJavaFX extends Application {

    // private String reverseString(String text) {

    // return new StringBuilder(text).reverse().toString();

    // }

    @Override
    public void start(Stage stage) throws IOException {

        ArrayList<Student> ourStudents;

        ourStudents = LoadStudents.loadStudents("data.txt");

        ComboBox<String> menu = new ComboBox<>();
        menu.getItems().addAll("Show All Students", "Search by Name");
        menu.setValue("Show All Students");

        TextField searchField = new TextField();
        searchField.setPromptText("Enter a name or part of a name");

        Button goButton = new Button("Go");

        TextArea results = new TextArea();
        results.setEditable(false);

        goButton.setOnAction(event -> {
            // System.out.println(event.getEventType()); // ACTION
            // System.out.println(event.getSource()); // The button
            StringBuilder output = new StringBuilder();

            if (menu.getValue().equals("Show All Students")) {
                for (Student student : ourStudents) {
                    output.append(student).append("\n");
                }
            } else {
                String searchName = searchField.getText().trim();

                if (searchName.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter a name to search.");
                    alert.showAndWait();
                    return;
                }

                for (Student student : ourStudents) {
                    if (student.getName().toLowerCase()
                            .contains(searchName.toLowerCase())) {
                        output.append(student).append("\n");
                    }
                }
            }

            if (output.length() == 0) {
                results.setText("No students found.");
            } else {
                results.setText(output.toString());
            }
        });

        // // Label instruction = new Label("What is your name?");

        // TextField nameField = new TextField();
        // nameField.setPromptText("Enter your name");

        // Button greetButton = new Button("Say Hello");

        // Label greeting = new Label();

        // greetButton.setOnAction(event -> {
        // String name = nameField.getText().trim();

        // if (name.isEmpty()) {
        // greeting.setText("Please enter your name.");
        // } else {
        // greeting.setText(this.reverseString("Hello, " + name + "!"));
        // }

        // Alert alert;

        // if (name.isEmpty()) {
        // alert = new Alert(Alert.AlertType.WARNING);
        // alert.setTitle("Missing Name");
        // alert.setHeaderText(null);
        // alert.setContentText("Please enter your name.");
        // } else {
        // String reversedName = reverseString(name);

        // alert = new Alert(Alert.AlertType.INFORMATION);
        // alert.setTitle("Greeting");
        // alert.setHeaderText(null);
        // alert.setContentText("Hello, " + reversedName + "!");
        // }

        // alert.initOwner(stage);
        // alert.showAndWait();
        // });

        // VBox layout = new VBox(
        // 12, instruction, nameField, greetButton, greeting);

        // VBox layout = new VBox(
        // 12, instruction, nameField, greetButton);
        VBox.setVgrow(results, Priority.ALWAYS);

        VBox layout = new VBox(12, menu, searchField, goButton, results);
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