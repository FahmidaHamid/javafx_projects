# JavaFX Project

### Check Java and Maven

=> Open a terminal and run:

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



