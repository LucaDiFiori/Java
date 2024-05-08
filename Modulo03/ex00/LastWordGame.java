import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*_______________________________LASTWORDGAME___________________________________
 * This program take a string as imput containing the number of time the trheads
 * should print the 2 wordsin a multithreaded way.
 * 
 * Main method: - The main method takes the input string and parses it to ta
 *                get the number of times the words should be printed.
 * 
 * 1. check if ther's an input string.
 * 2. check if the input string starts with "--count=".
 *    else
 * 3. create a pattern to match the digits inthe input string 
 *    (Using //d+ regex pattern to match one or more digits)
 * 4. create a matcher to find the digits in the input string.
 *    (Note:  
 *           i. pattern.compile() method of the pattern class used to create a
 *              pattern object.
 *           ii. pattern.matcher() method of the pattern class used to create a 
 *           matcher object)
 * 5. while the matcher finds the digits in the input string, parse the digits
 * 6. create 2 ThreadPrinter objects with the words "Egg" and "Hen" and the 
 *    number of times the words should be printed. than start the threads.
 */
public class LastWordGame {
    public static void main(String[] args) throws InterruptedException{
        int count = 0;
        
        if (args.length > 0) {                                                  //1
            if (!args[0].startsWith("--count=")) {
                System.out.println("Invali argumenti. Use: --count=<numero>");
                return;                                                         //2
            } 
            else {
                Pattern pattern = Pattern.compile("\\d+");                      //3
                Matcher matcher = pattern.matcher(args[0]);                     //4
                while (matcher.find()) {
                    count = Integer.parseInt(matcher.group());                  //5
                }
                
                ThreadPrinter t1 = new ThreadPrinter("Egg", count);
                ThreadPrinter t2 = new ThreadPrinter("Hen", count);                 
                
                t1.start();
                t2.start();                                                         //6

                t1.join();
                t2.join();
                
                for (int i = 0; i < count; i++) {
                    System.out.println("Human");
                }
            }
        }
        else
            return;
    }
}