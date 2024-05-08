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
/*____________________________DOWNLOADERCLASS___________________________________
 * This class is responsible for downloading the web pages from the internet.
 * 
 * Every thread object of this class extracts, in a synchronized bloc, 
 * an URL from the queue and stores the link in a local variable called url.
 * The thread then downloads the content of the URL and stores it in a file.
 * 
 * 
 * RUN METHOD:
 *1. if the queue is not empty:
 *2. poll the first URL from the queue and download it
 *3. verify if the URL is already in the downloadedUrls set. If not:
 *4. extract the extension of the file from the URL
 *5. print a message to the console that the thread is starting to download the file 
 *
 *6. open a stream from the URL. In detail:
 *         - URL.openStream(): returns an InputStream object that reads from the
 *                            open connection to the resource referred to by this
 *                            URL
 *         - the InputStream in = : creates a new InputStream object from the
 *                                  URL object. I'm assigning tghe input stream 
 *                                  from the URL to the variable in. 
 *                                  The variable in is used to read the content
 *                                  of the URL
 * 
 *        note: the try-with-resources statement: try (InputStream in = url.openStream()) {
 *              is used to declare one or more resources that are automatically closed
 *              after the program is finished with them. The resources are declared in
 *              the try block and are closed when the try block is finished. The resources
 *              must implement the AutoCloseable interface. In this case, the input stream
 *              is automatically closed after the try block is finished
 * 
 * 7. Copy the content of the input stream to a file. In detail:
 *        - Files.copy(...) : copies all bytes from an input stream to a file
 *                            acepts 3 arguments:  the input stream, the path
 *                                                 to the file and the options
 *        - Paths.get(...)  : returns a Path object from the string passed as
 *                            argument. In this case, the path to the file
 *        Im copying the content of the input stream to a file named "file" +
 *        the file number + ".html" (in this dyrecroty. With path.get() 
 *        i'm specifying the path to the file)
 * 
 * 8. Add the URL to the downloadedUrls set. This set is used to keep track of the
 *    URLs that have been downloaded. If the URL is already in the set, the file
 *    is not downloaded again
 * 
 * 9. Print a message to the console that the thread has finished downloading the file  
 * 
 */




class DownloaderClass extends Thread {
    private Queue<URL> urlQueue;
    Set<URL> downloadedUrls = new HashSet<>();
    int i;

    public DownloaderClass(int i, Queue<URL> urlQueue) {
        this.urlQueue = urlQueue;
        this.i = i;
    }

    public void run() {
        while (true) {
            if (!urlQueue.isEmpty()) {                                          //1
                URL url = urlQueue.poll();                                      //2
                
                if (!downloadedUrls.contains(url)) {                            //3
                
                String ext = url.toString().substring(url.toString().lastIndexOf(".")); //4
                
                System.out.println(Thread.currentThread().getName()             //5
                + " Start downloading file number " + i + ": " + url);

                    try {
                        try (InputStream in = url.openStream()) {               //6
                            Files.copy(in, Paths.get("file" + i + ext));        //7
                            downloadedUrls.add(url);                            //8
                        }
                    } catch (IOException e) {
                        System.err.println("Error while downloading file: " + url);
                    }

                    System.out.println(Thread.currentThread().getName()         //9
                    + " Finished downloading file number " + i);       

                } else {
                    System.out.println("URL already downloaded: " + url);
                }
            }
        }
    }
}