import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/*_____________________________SIGNATURE READER_________________________________

   DESCRIPTION: This class read the file signatures.txt and store the file type 
                and the signature in a map.

 * 1. map and path variable declaration
 *    Map take two parameters, the first one is the file type and the second 
 *    one is the signature
 * 
 * 2. costructor
 * 
 * 3. readSignatures() method:
 *    i. open the file signatures.txt : to do so creat a FileInputStream object 
 *                                      specifiing the path of the file
 *    ii. create a Scanner object to read the file
 *    iii. read the file line by line
 *    iv. split the line in two parts: the file type and the signature
 *    v.  create two strings to store the file type and the signature
 *    vi. add the file type and the signature to the map
 *    vii. close the scanner  
 *    viii. catch the FileNotFoundException
 */
public class SignatureReader {
    
    private Map<String, String> signature;                                
    String path;                                                                // 1.

    /*_________________________COSTRUCTOR____________________________________ */// 2.
    public SignatureReader(String path) {                                                
        signature = new HashMap<>();
        this.path = path;
    }

    /*__________________________METHONDS________________________________________ */
    public void mapCreator() {                                                  // 3.
        try {          
            FileInputStream sigFile = new FileInputStream(path);                // 3.i
            Scanner scanner = new Scanner(sigFile);                             // 3.ii
            
            while (scanner.hasNextLine()) {                                     // 3.iii
                String sigLine = scanner.nextLine();
                String[] sigParts = sigLine.split(",");                         // 3.iv
                
                String fileType = sigParts[0];        
                String sigType  = sigParts[1];                                  // 3.v
                
                signature.put(fileType, sigType);                               // 3.vi
            }

            scanner.close();                                                    // 3.vii
        }
        catch (FileNotFoundException e) {
            System.out.println("Errore: file signature.txt not found.");     // 3.viii
        }
    }

    public void printMap() {
        for(Map.Entry<String, String> entry : signature.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public Map<String, String> getSignatureMap() {
        return signature;
    }


    /*____________________Set<Map.Entry<String, String>>________________________
        * Return the set of the map entries
     */
    public Set<Map.Entry<String, String>> getSignatureSet() {
        return signature.entrySet();
    }
}






