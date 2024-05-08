/*______________________________THREADPRINTER___________________________________
 * threadPrinter is a class that has two methods eggPrint and henPrint.these methods
 * are synchronized and they are used to print the words "Egg" and "Hen" respectively.
 * 
 * 1. Create a private boolean called trafficLight and set it to true. This variable
 *    will be used to control the flow of the program.
 * 2. Create a constructor that initializes the trafficLight variable.
 * 3. Create a synchronized method called eggPrint that:
 *    - Waits while trafficLight is false.
 *    - Prints "Egg".
 *    - Sets trafficLight to false.
 *    - Notifies all threads that are waiting for this object's monitor (trafficLight) 
 *      to wake up.
 *  
 *  4. Create a synchronized method called henPrint that::
 *     - Waits while trafficLight is true.
 *     - Prints "Hen".
 *     - Sets trafficLight to true. 
 *    - Notifies all threads that are waiting for this object's monitor (trafficLight)
 *      to wake up.
 */
public class ThreadPrinter {
    private boolean trafficLight;

    public ThreadPrinter() {
        this.trafficLight = true;
    }

    public synchronized void eggPrint() {
        while (!trafficLight) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");
        trafficLight = false;
        notify();
    }

    public synchronized void henPrint() {
        while (trafficLight) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        trafficLight = true;
        notify();
    }
}

/*
 * NOTA: Perchè usare synchronized?
 * 
Se un thread chiama il metodo eggPrint() e un altro thread chiama il metodo 
henPrint() simultaneamente, e questi due metodi non sono sincronizzati, 
potrebbe verificarsi una situazione in cui entrambi i thread modificano 
contemporaneamente lo stato condiviso (trafficLight) senza una corretta coordinazione. 
Questo potrebbe portare a risultati imprevisti o indesiderati

 syncronized implica che se una qualsiasi parte di codice contrassegnata con 
 syncronized viene chiamata anche da un solo thread l'altro non potrà entrare 
 in un altra area contrassegnata da syncronized:



 synchronized in Java garantisce l'accesso esclusivo ad un blocco di codice o 
 ad un metodo da parte di un solo thread alla volta. Quando un thread entra in 
 una parte di codice contrassegnata come synchronized, acquisisce un "lock" 
 associato a quell'oggetto o a quella classe. Gli altri thread che tentano di 
 accedere a un altro blocco di codice contrassegnato come synchronized sullo 
 stesso oggetto o sulla stessa classe devono aspettare finché il lock non viene 
 rilasciato dal thread che lo detiene.

Quindi, se un thread ha acquisito il lock associato a un blocco di codice 
sincronizzato o a un metodo, gli altri thread che cercano di accedere allo stesso 
blocco di codice o metodo devono aspettare che il lock venga rilasciato prima 
di poterlo eseguire. Ciò implica che non può esserci più di un thread 
contemporaneamente all'interno di qualsiasi blocco di codice sincronizzato 
su uno specifico oggetto o classe.

NOTA: Questo funziona solo se i thread che stanno cercando di accedere al 
blocco di codice sincronizzato condividono lo STESSO OGGETTO O CLASSE
*/