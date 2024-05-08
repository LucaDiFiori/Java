import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyncLastWordGame {
    public static void main(String[] args) throws InterruptedException{
        int count = 0;
        boolean trafficLight = true;
        
        if (args.length > 0) {                                                  
            if (!args[0].startsWith("--count=")) {
                System.out.println("Invali argumenti. Use: --count=<numero>");
                return;                                                         
            } 
            else {
                Pattern pattern = Pattern.compile("\\d+");                      
                Matcher matcher = pattern.matcher(args[0]);                     
                while (matcher.find()) {
                    count = Integer.parseInt(matcher.group());                  
                }

                ThreadPrinter threadPrinter = new ThreadPrinter();
                Egg egg = new Egg(threadPrinter, count);
                Hen hen = new Hen(threadPrinter, count);

                Thread eggThread = new Thread(egg);
                Thread henThread = new Thread(hen);

                eggThread.start();
                henThread.start();

            }
        }
    }
}