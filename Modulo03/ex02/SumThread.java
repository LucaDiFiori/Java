/*_____________________________SUMTHREAD_______________________________________
 * This class is used to create a thread that will calculate the sum of the
 * elements in the array from the start index to the end index.
 * 
 * RUN METHOD:
 * 1. The run method will iterate through the array from the start index to the
 *   end index summed the elements in the array.
 * 2. print the thread name, start index, end index, and the sum of the elements
 * 3. in a synchronized block, add the partial sum to the sum of the elements in
 *    the array. 
 *    Note: Program.sum is a static variable in the Program class. So, it can be
 *          accessed by all the threads and every modification to it will be
 *          visible to all the threads.
 * 
 */

public class SumThread implements Runnable {
    private int start;
    private int end;
    private int partialSum;
    private Integer[] array;

    public SumThread(Integer[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }
    
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {                                     //1
            partialSum += array[i];
        }
        System.out.println("Thread " + Thread.currentThread().getName() + ": "
        + "from " + start + " to " + end + " sum is: " + partialSum);              //2
        
        synchronized (this) {
            Program.threadSum += partialSum;                                    //3
        }
    }
}