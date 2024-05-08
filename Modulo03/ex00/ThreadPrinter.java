/*_______________________________TREADPRINTER___________________________________
 * This class is used to print the output of the program in a multithreaded way.
 * The class extends the Thread class, which allows it to be run as a separate
 * thread.
 * 
 * 1. Fields: - word: a String representing the word to be printed.
 *            - count: an int representing the number of times the word should 
 *              be printed. 
 * 2. Constructor: - ThreadPrinter(String word, int count): initializes the 
 *                  word and count fields with the values passed as arguments.
 * 
 * 3. Methods: - run(): overrides the run() method of the Thread class. This
 *               method contains the logic for printing the word a specified 
 *               number of times.
*/

public class ThreadPrinter extends Thread {
    private final String word;
    private final int count;                                                    // 1

    public ThreadPrinter (String word, int count) {
        this.word = word;
        this.count = count;
    }                                                                           // 2

    @Override                                                                   // 3
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(word);
            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }  
    }
}