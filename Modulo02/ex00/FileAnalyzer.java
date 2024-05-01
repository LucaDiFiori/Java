import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;
import java.io.*;
/*_______________________________FILEANALYZER___________________________________
 * FileAnalyzer is the main class that will be used to run the program.
 * It will take in a file path and analyze the file to determine the file type.
 * 
 * 1. declare a SignatureReader object and a Scanner object initializing it
 * 2. ask the user for the file path
 * 3. call the analyzer method to determine the file type
 * 4. if the file type is undefined, print "UNDEFINE" else write the file type to a file
 * 
 * /*___________________________ANALIZER method_________________________________ 
 * 5. create the hash map
 * 6. initialize the set of entries
 * 7. create a MagicNumber objectù
 * 8. call the getBytesReadString method to get the magic number as an hexadecimal string
 * 9. iterate through the set of entries and check if the magic number is contained in the file
 */
public class FileAnalyzer {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);                               //1
        String path;
        String returnType;                             
        
        System.out.print("-> ");                                                //2
        path = scanner.nextLine();
        scanner.close();
        
        returnType = analyzer(path);                                            //3
        if (returnType.equals("UNDEFINE")) {                                    //4,5
            System.out.println("UNDEFINE");
        } 
        else {
            try {
                System.out.println("PROCESSED");
                PrintWriter writer = new PrintWriter("outsignature.txt");
                writer.println(returnType);
                writer.close();
            }
            catch (IOException e) {
                    System.out.println("An error occurred.");
                }

            }
        }
    
    
    private static String analyzer(String path) {
        String defUndef = "UNDEFINE";
        SignatureReader sigMap = new SignatureReader("signature.txt");
        MagicNumber mn;
        Set<Map.Entry<String, String>> set;
        String magicHexStr;
        
        sigMap.mapCreator();                                                    //5
        set = sigMap.getSignatureSet();                                         //6
        
        mn = new MagicNumber(path);                                             //7
        magicHexStr = mn.getBytesReadString();                                  //8
        
        for (Map.Entry<String, String> entry : set) {                           //9
            if (magicHexStr.trim().contains(entry.getValue())) {
                defUndef = entry.getKey();
                return defUndef;
            }
        }
        return defUndef;
    }
}