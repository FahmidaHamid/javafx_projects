# JavaFX Project

### Check Java and Maven
Open a terminal and run:

```bash

java -version
javac -version
mvn -version

```
On your Mac, if Maven uses a different Java version, use the settings we established:

```bash

export JAVA_HOME=$(/usr/libexec/java_home -v 26)
export PATH="$JAVA_HOME/bin:$PATH"

```
Then check the versions again. These settings apply to the current terminal session.

### Create a new project folder

From your existing **javafx_projects** [for exmaple] directory:

```bash

mkdir -p label-demo/src/main/java/demo
cd label-demo

```

### Open the folder in VS Code

```bash

code .

```

If code is unavailable, use **VS Code → File → Open Folder**, and select **label-demo**.

### Create pom.xml

Create this file directly inside `label-demo`:

```bash
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>demo</groupId>
    <artifactId>label-demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.release>26</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>25</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.14.0</version>
            </plugin>

            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>demo.LabelApp</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
This configuration uses the Java 26 and JavaFX 25 combination from your working project.



### Create the Application Class

Inside src/main/java/demo, create `LabelApp.java`:

```java
package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LabelApp extends Application {

    @Override
    public void start(Stage stage) {
        Label message = new Label("Welcome to JavaFX!");

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

```
### Run the application

In the terminal, make sure you are inside `label-demo`, the folder containing `pom.xml`. 

Run:
```bash
mvn javafx:run

```
Use this command instead of VS Code’s Run Java button.