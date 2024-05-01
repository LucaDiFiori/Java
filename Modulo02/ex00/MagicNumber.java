import java.io.FileInputStream;
import java.io.FileNotFoundException;


/*________________________________MAGICNUMER____________________________________

   DESCRIPTION: this method read the first 8 bytes of a file and store them in a 
                byte array.

 * 1. filePath variable, fis object and byte array declaration
 * 2. costructor: take the path of the file as parameter and store it in the 
 *                filePath variable. 
 *                Create a FileInputStream object specifiing the path of the file
 *                and store it in the fis variable.
 *                Create a byte array of 8 bytes.
 *                Set bytesReadLength to 0.  
 *      
 * 3. readMagicNumber() method: 
 *    i. read the file and store the bytes read in the byte array bytesRead
 *    ii. catch the exception if needed    
 * 
 * 4. getBytesRead() method: return the byte array bytesRead   
 * 
 * 5. getBytesReadString() method: return the bytes read as a string
 *    - create a StringBuilder object
 *    - read the magic number
 *    - for each byte in the byte array append the byte to the StringBuilder
 *    - with "string.format" convert the byte to an hexadecimal string
 *    - return the StringBuilder as a string (remove the last space)
 * 
 * 6. printBytesRead() method: print the bytes read
 * 
 */
public class MagicNumber {
    private FileInputStream fis;
    private byte[] bytesRead;
    private int bytesReadLength;

    public MagicNumber(String filePath) {
        try {
            fis = new FileInputStream(filePath);
        }
        catch (FileNotFoundException e) {
            System.out.println("Errore: file path not fount.");
            System.exit(1);
        }
        bytesRead = new byte[8];
        bytesReadLength = 0;
    }

    /*________________________________METHONDS_______________________________ */
    public void readMagicNumber() {
        try {
            bytesReadLength = fis.read(bytesRead);
        }
        catch (Exception e) {
            System.out.println("Errore: read error.");
            System.exit(2);
        }
    }

    public byte[] getBytesRead() {
        return bytesRead;
    }

    public String getBytesReadString() {
        StringBuilder hexSignature = new StringBuilder();
        readMagicNumber();
        for (int i = 0; i < bytesReadLength; i++) {
            hexSignature.append(String.format("%02X ", bytesRead[i]));
        }
        return hexSignature.toString().trim();
    }

    public void printBytesRead() {
        for (int i = 0; i < bytesReadLength; i++) {
            System.out.printf("%02X ", bytesRead[i]);
        }
    }
}
