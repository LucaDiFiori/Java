import java.util.Random;

/*______________________________________________________________________________
 * In this program, we will implement another version of the ex02 program
 * whitout using synchronized blocks.
 * I'll start commenting on the variations between the two codes.
 * 
 * 1. Create an array of threads, each thread will be responsible for calculating
 * 2. in a for loop, we will create the threads, passing the start and end indexes
 *    of the array that each thread will be responsible for calculating, putting
 *    them in the array of threads and starting them.   
 * 
 * note: int endIndex = (i == threadsCount - 1) ? arraySize - 1 : (i + 1) * chunkSize - 1;
 *       - (i == numThreads - 1): checks if "i" is the last thread (numThreads - 1)
 *       - if true the end index will be arraySize - 1 (the last element of the array)
 *       - if false the end index will be (i + 1) * blockSize - 1 (the next block)
 * 3. We will wait for all threads to finish their calculations using the join method.
 * 4. Finally, we will add the sum of each thread to the variable threadSum and print
 *    the result.
 */

 public class Main {
    private static final int MAX_ARRAY_SIZE = 2000000;
    private static final int MAX_MODULO = 1001;
    public static int threadSum = 0;
    
    private static void checkArgs(String[] args) {                              
        if (args.length != 2) {
            System.out.println("Usage: two arguments required");
            System.exit(-1);
        }
        if (!args[0].matches("--arraySize=\\d+") || !args[1].matches("--threadsCount=\\d+")) {
            System.out.println("Usage: java Program <--arraySize=> <--threadsCount=>");
            System.exit(-1);
        }
    }

    private static Integer[] generateArray(int size) {                          
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(MAX_MODULO);
        }
        return array;
    }

    private static void singleThreadSum(Integer[] array) {                      
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("single thread Sum: " + sum);
    }




    public static void main(String[] args) {
        checkArgs(args);                                                        

        int arraySize = Integer.parseInt((args[0].split("=")[1]));
        int threadsCount = Integer.parseInt(args[1].split("=")[1]);
                 
        if (arraySize > MAX_ARRAY_SIZE || threadsCount > arraySize) {
            System.out.println("Invalid arguments");
            System.exit(-1);                                                    
        }

        Integer[] array = generateArray(arraySize);
        singleThreadSum(array);
        int chunkSize = arraySize / threadsCount;

        SumThread[] threads = new SumThread[threadsCount];                      //1

        for (int i = 0; i < threadsCount; i++) {                                //2
            int startIdx = i * chunkSize;
            int endIndex = (i == threadsCount - 1) ? arraySize - 1 : (i + 1) * chunkSize - 1; //note
            threads[i] = new SumThread(array, startIdx, endIndex);              
            threads[i].start();
        }

        try {                                                                   //3
            for (int i = 0; i < threadsCount; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted");
            System.exit(-1);
        }

        for (int i = 0; i < threadsCount; i++) {                                //4
            threadSum += threads[i].getSum();
        }
        System.out.println("multi thread Sum: " + threadSum); 
    }
 }