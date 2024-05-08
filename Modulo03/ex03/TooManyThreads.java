
/*_________________________TOOMANYTHREADS_______________________________________
 * COMMON METHODS:
 * - checkArgs(String[] args): checks if the arguments are correct
 * - queueGenerator(String fileName): generates a queue of URLs from a file
 *   1. creates a FileReader object from the file name passed as argument
 *      and a BufferedReader object from the FileReader object
 *   2. reads the file line by line and creates a URL object from each line
 *      (URL url = new URL(line)) and adds it to the queue
 * 
 * MAIN:
 *   1. checks the arguments
 *   2. gets the number of threads from the argument
 *   3. generates a queue of URLs from the file
 *   4. creates an array of DownloaderClass objects and starts each thread 
 *   5. joins each thread
 */


import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

public class TooManyThreads {
    private static final String URLS_FILE_NAME = "files_urls.txt";

    private static void checkArgs(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: One argument required");
            System.exit(1);
        }
        if (!args[0].matches("--threadsCount=\\d+")) {
            System.err.println("Usage: Argument must be --threadsCount=N where N is a number");
            System.exit(1);
        }
    }
    
    private static Queue<URL> queueGenerator() {
        Queue<URL> urlQueue = new LinkedList<>();
        String line;

        try {
            FileReader fileReader = new FileReader(URLS_FILE_NAME);
            BufferedReader reader = new BufferedReader(fileReader);             //1

            while ((line = reader.readLine()) != null) {                        //2
                URL url = new URL(line);
                urlQueue.offer(url);
            }
        } catch (IOException e) {
            System.err.println("Error while reading file: " + URLS_FILE_NAME);
            System.exit(-1);
        }
        return urlQueue;                                            
    }




    public static void main(String[] args) {
        checkArgs(args);                                                        //1
        int threadsCount = Integer.parseInt(args[0].split("=")[1]);             //2
        
        Queue<URL> urlQueue = queueGenerator();                                 //3
        if (urlQueue.isEmpty()) {
            System.err.println("Error: Empty file");
            System.exit(-1);
        }

        DownloaderClass[] downloadersThreads = new DownloaderClass[threadsCount]; //4
        for (int i = 0; i < threadsCount; i++) {
            downloadersThreads[i] = new DownloaderClass(i + 1, urlQueue);
            downloadersThreads[i].start();
        }
        try {
            for (DownloaderClass downloader : downloadersThreads) {             //5
                downloader.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Error while joining threads");
            System.exit(-1);
        }
    }
}