/*______________________________________________________________________________
 * 1. Telling java that the class Main belongs the package edu.42Roma.printer.app
 * 2. Importing the package edu.42Roma.printer.logic
 * 3. checks the arguments passed to the program
 * 4. Assigning the first argument to the variable WHITE
 * 5. Assigning the second argument to the variable BLACK
 * 6. Creating an instance of the ImageConverter class
 * 7. Creating the matrix calling the ConvertImageToMatrix method of the ImageConverter class
 * 9. Printing the charMatrix array
 */

package edu.roma42.printer.app;                                                   //1

import edu.roma42.printer.logic.ImageConverter;                                 //2

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3 || args[0].length() != 1 || args[1].length() != 1) {       //3
            System.out.println("Usage: java Main <whiteChar> <blackChar> <imagePath>");
            System.exit(1);
        }

        char WHITE = args[0].charAt(0);                                                 //4
        char BLACK = args[1].charAt(0);                                                 //5

        try {
            ImageConverter imageConverter = new ImageConverter(WHITE, BLACK, args[2]);  //6
            char[][] charMatrix = imageConverter.ConvertImageToMatrix(args[2]);         //7

            for (int i = 0; i < charMatrix.length; i++) {                               //9
                for (int j = 0; j < charMatrix[i].length; j++) {
                    System.out.print(charMatrix[i][j]);
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading the image file: " + e.getMessage());
            System.exit(-1);
        }
    }
}


/*
 * ABOUT THIS PROGRAM:
 * This program reads an image file and converts it to a textual representation.
 * 
 * COMPILATION:
 * ```bash
make
```
This will execute the command `javac -d build src/java/edu/roma42/printer/app/Main.java src/java/edu/roma42/printer/logic/ImageConverter.java` 
which will compile the program and create the build directory inside the target directory.

LAUNCH AND EXECUTE:
```bash
java -cp ./target edu.roma42.printer.app.Main <char for white pixels> <char for black pixels> <full path to black & white bmp image>
```
**Note:** 
- -cp ./target: the -cp option is used to specify the classpath. Classpath is a JVM parameter that specifies the location of the compiled classes and packages.
- edu.roma42.printer.app.Main: This is the fully qualified name of the class that contains the main method.
 */