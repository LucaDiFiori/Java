import java.util.Random;
import java.util.ArrayList;
/*_________________________________PROGRAM______________________________________
 * COMMON VARIABLES:
 * 1. MAX_ARRAY_SIZE - maximum size of the array
 * 2. MAX_MODULO - maximum value of the elements in the array
 * 3. threadSum - the sum of the elements of the array in a thread
 *     NOTE: when a variable is declared as static, it means that it is shared 
 *           among all instances of the class and can be accessed and modified 
 *           from any part of the program, even from other classes or methods.
 * 
 *           If a static variable is modified by some other class or method, 
 *           its new value will be reflected for all other users of that variable, 
 *           regardless of where and how it was modified. 
 *           This is because static variables are associated with the class itself 
 *           rather than a specific instance of the class, so it is not necessary to 
 *           create an instance of the class to access or modify the static variable.
 * 
 * 
 * COMMON METHODS:
 * 1. checkArgs(String[] args) - checks if the arguments are correct
 * 2. generateArray(int size) - generates an array of random integers with the given size
 * 3. singleThreadSum(Integer[] array) - sums the elements of the array in a single thread
 * 
 * 
 * MAIN METHOD:
 * 1. main(String[] args) - checks the arguments and starts the program
 * 2. split the arguments and get the arraySize and threadsCount
 *    note: args[0].split("=")[1]): splits the first argument using "=" and gets 
 *                                  the second part ([1]) which is the number
 *    Same for the second argument. Then checks if the arguments are valid
 * 3. generates an array of random integers
 * 4. sums the elements of the array in a single thread
 * 5. calculate the chunk size for
 *    initialize the start and end indexes
 *    create an ArrayList of threads
 * 6. in a for loop, create a SumThread object with the array, start, and end indexes
 *    create a new thread with the SumThread object and add it to the ArrayList.
 *    Than update the start and end indexes
 * 7. create the last SumThread object with the remaining elements of the array
 *    (from the last end index to the end of the array)
 * 8. start all the threads in the ArrayList
 * 9. join all the threads in the ArrayList
 * 10. print the sum of the elements of the array calculated by the threads
 */

public class Program {
    private static final int MAX_ARRAY_SIZE = 2000000;
    private static final int MAX_MODULO = 1001;
    public static int threadSum = 0;
    
    private static void checkArgs(String[] args) {                              //1
        if (args.length != 2) {
            System.out.println("Usage: two arguments required");
            System.exit(-1);
        }
        if (!args[0].matches("--arraySize=\\d+") || !args[1].matches("--threadsCount=\\d+")) {
            System.out.println("Usage: java Program <--arraySize=> <--threadsCount=>");
            System.exit(-1);
        }
    }

    private static Integer[] generateArray(int size) {                          //2
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(MAX_MODULO);
        }
        return array;
    }

    private static void singleThreadSum(Integer[] array) {                      //3
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("single thread Sum: " + sum);
    }


    public static void main(String[] args) {
        checkArgs(args);                                                        //1

        int arraySize = Integer.parseInt((args[0].split("=")[1]));
        int threadsCount = Integer.parseInt(args[1].split("=")[1]);             
        if (arraySize > MAX_ARRAY_SIZE || threadsCount > arraySize) {
            System.out.println("Invalid arguments");
            System.exit(-1);                                                    //2
        }

        Integer[] array = generateArray(arraySize);                             //3
        singleThreadSum(array);                                                 //4

        int chunkSize = arraySize / threadsCount;
        int start = 0;
        int end = chunkSize;
        ArrayList<Thread> threads = new ArrayList<>();                          //5

        for (int i = 0; i < (threadsCount - 1); i++) {                          //6
            SumThread sumThread = new SumThread(array, start, end);
            Thread thread = new Thread(sumThread);
            threads.add(thread);
            start += chunkSize + 1;
            end += start;
        }
        SumThread sumThread = new SumThread(array, start, arraySize - 1);       //7
        Thread thread = new Thread(sumThread);
        threads.add(thread);
        
        for (int i = 0; i < threadsCount; i++) {                                //8
            threads.get(i).start();
        }

        for (int i = 0; i < threadsCount; i++) {                                //9
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted");
                System.exit(-1);
            }
        }

        System.out.println("multi thread Sum: " + threadSum);                   //10
    }
}

/*
 * NOTA SYNCHRONIZED:
 * Nel contesto del tuo codice, synchronized (this) viene utilizzato per garantire 
 * l'accesso sincronizzato alla variabile threadSum, che è condivisa tra più thread.
 * Quando un blocco di codice è contrassegnato come synchronized (this), significa 
 * che solo un thread alla volta può eseguire quel blocco di codice per l'istanza 
 * specifica dell'oggetto su cui è stato chiamato il metodo. In questo caso, 
 * l'oggetto su cui è chiamato synchronized è l'istanza corrente di ThreadSuma.
 * 
 * Quindi, quando più istanze di ThreadSuma stanno eseguendo il metodo run() 
 * contemporaneamente in thread separati, solo un thread alla volta può eseguire 
 * il blocco di codice all'interno di synchronized (this). Gli altri thread devono 
 * aspettare finché il blocco di codice non viene rilasciato dal thread che lo detiene.
 * 
 * Nel tuo caso specifico, stai aggiungendo la somma calcolata dal thread alla 
 * variabile threadSum all'interno del blocco di codice synchronized (this) 
 * per garantire che questa operazione di aggiunta avvenga in modo sincronizzato 
 * e non causi inconsistenze o corruzioni dei dati quando eseguita da più thread 
 * contemporaneamente.
 * 
 * QUINDI:
 * Quando uno qualsiasi dei thread arriva al blocco di codice contrassegnato 
 * come synchronized, utilizzerà se stesso (l'istanza corrente di ThreadSuma, 
 * poiché this si riferisce all'istanza corrente dell'oggetto) per acquisire un 
 * lock. Questo significa che solo un thread alla volta può eseguire quel blocco 
 * di codice per l'istanza specifica di ThreadSuma. Quindi, una volta che un 
 * thread ha acquisito il lock e sta eseguendo il blocco di codice, gli altri 
 * thread devono aspettare finché il lock non viene rilasciato.
 * 
 * All'interno di questo blocco di codice sincronizzato, il thread eseguirà la 
 * somma e memorizzerà il risultato nella variabile threadSum. Una volta 
 * completata l'operazione all'interno del blocco di codice sincronizzato, 
 * il lock sull'istanza di ThreadSuma verrà rilasciato e un altro thread potrà 
 * accedere a quel blocco di codice, se necessario.
 */