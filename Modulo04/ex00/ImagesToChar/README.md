# About this program:
This program reads an image file and converts it to a textual representation.

# Compilation:
```bash
make
```
This will execute the command:
 javac -d build src/java/edu/roma42/printer/app/Main.java src/java/edu/roma42/printer/logic/ImageConverter.java 

which will compile the program and create the build directory inside the target directory.

# Launch and execute
```bash
java -cp ./target edu.roma42.printer.app.Main <char for white pixels> <char for black pixels> <full path to black & white bmp image>
```
**Note:** 
- -cp ./target: the -cp option is used to specify the classpath. Classpath is a JVM parameter that specifies the location of the compiled classes and packages.
- edu.roma42.printer.app.Main: This is the fully qualified name of the class that contains the main method.

# Example use:
```bash
java -cp ./target edu.roma42.printer.app.Main . o it.bmp
```
