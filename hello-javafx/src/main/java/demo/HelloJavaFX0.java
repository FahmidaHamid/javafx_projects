package demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFX0 extends Application {

    @Override
    public void start(Stage stage) {
        
        Button button = new Button("Hello");

        VBox myVBox = new VBox(button);
        myVBox.setPadding(new Insets(20));
        
        Scene scene = new Scene(myVBox, 300, 200);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Application is closing.");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
