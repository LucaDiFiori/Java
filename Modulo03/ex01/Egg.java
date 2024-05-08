/*___________________________________EGG________________________________________
 * This class is responsible for printing the word "Egg" in the console.
 * Implements Runnable interface.
 * 
 * 1. Create a private final ThreadPrinter object called threadPrinter and
 *    a private final int called count.
 * 2. Create a constructor that receives a ThreadPrinter object and an int as
 *    parameters and assigns them to the corresponding attributes.
 * 3. Override the run method: 
 *    - Iterate from 0 to count.
 *    - Call the eggPrint method from the threadPrinter object.
 */
public class Egg implements Runnable{
    private final ThreadPrinter threadPrinter;
    private final int count;

    public Egg(ThreadPrinter threadPrinter, int count) {
        this.threadPrinter = threadPrinter;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            threadPrinter.eggPrint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}