/*
 * 1. Creating a file object with the path of the image. This object will be 
 *    used to read the image.
 * 
 * 2. Reading the image and storing it in a BufferedImage object:
 *    
 *    BUFFEREDIMAGE:
 *    BufferedImage is a class in Java that is used to store an image in
 *    memory and manipulate it. 
 *    It is used to create an image from a file, from an input stream, or from a URL. 
 *    It is also used to draw an image on the screen.
 * 
 *    A BUFFEREDIMAGE OBJECT is an object that stores the reference to the 
 *    image read from the file.
 *    It rappresents a raster image with an accessible buffer of image data.
 *    When a BufferedImage object is created, the compiler allocates memory for
 *    the image data and stores the image in the memory.
 * 
 *    IMAGEIO:
 *    ImageIo is a class in java that implements methods to read and write images
 *    in different formats.
 * 
 *    IMAGIO-READ METHOD:
 *    The read method of the ImageIO class is used to read an image from the file
 *    and store it in a BufferedImage object. The read method takes a file object
 *    as an argument and returns a BufferedImage object.
 *     
 * 3. Getting the width and height of the image with the getWidth() and getHeight()
 *    methods of the BufferedImage class.
 * 
 * 4. Creating a 2D char array to store the textual representation of the image.
 * 
 * 5. Scanning each pixel of the image:
 *    i. getting an integer that represents the color of the pixel at the current
 *       possition with the getRGB() method of the BufferedImage class.
 *    ii. Checking if the color is black or white and assigning the corresponding
 *        character to the charMatrix array.
 */

 package edu.roma42.printer.logic;

 import java.awt.Color;
 import java.awt.image.BufferedImage;
 import java.io.File;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import java.awt.*;
 
 
 public class ImageConverter {
 
     private final char whiteChar;
     private final char blackChar;
     private final String imagePath;
 
     public ImageConverter(char whiteChar, char blackChar, String imagePath) {
         this.whiteChar = whiteChar;
         this.blackChar = blackChar;
         this.imagePath = imagePath;
     }
 
     public char[][] ConvertImageToMatrix(String imagePath) throws IOException {
         File file = new File(imagePath);                                        //1
         BufferedImage image = ImageIO.read(file);                               //2
         int width = image.getWidth();
         int height = image.getHeight();                                         //3
         char[][] charMatrix = new char[height][width];                          //4
 
         for (int y = 0; y < height; y++) {
             for (int x = 0; x < width; x++) {                                   //5
                 int color = image.getRGB(x , y);                                //5.i
                 if (color == Color.BLACK.getRGB()) {                            //5.ii                             //5.ii
                     charMatrix[y][x] = blackChar;
                 } else {
                     charMatrix[y][x] = whiteChar;
                 }
             }
         }
         return charMatrix;
     }
 
 }