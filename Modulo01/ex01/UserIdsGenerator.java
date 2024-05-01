/**
 * NOTA: SINGLETONE:
 * Il Singleton pattern è un design pattern creazionale che garantisce che
 * una classe abbia una sola istanza e fornisce un punto di accesso globale
 * a questa istanza.
 *
 * Le caratteristiche principali del Singleton pattern sono:
 * - Una sola istanza: Garantisce che una classe abbia una sola istanza in
 *                     tutto il programma.
 * Accesso globale: Fornisce un modo per accedere all'istanza singleton da
 *                  qualsiasi punto del programma.
 *
 * Per rendere una classe un "Singletone":
 * - dovrà avere il metodo costruttore privato, cosi che non posso essere
 *   chiamata da nessun'altra classe.
 * - implementare un metodo per ottenere l'istanza del signletone che controlli
 *   se un'istanza è già stata creata e che la crei solo se questo non è avvenuto
 *
 *
 * NOTA: STATIC
 * 1) Variabili statiche: Le variabili statiche sono condivise tra tutte le istanze
 *                        di una classe e appartengono alla classe stessa anziché a
 *                        un'istanza specifica della classe.
 *                        Nell'implementazione del Singleton pattern, la variabile
 *                        statica che contiene l'istanza unica della classe assicura
 *                        che tutte le chiamate a getInstance() restituiscano la stessa istanza.
 *
 * 2) Metodi statici: I metodi statici appartengono alla classe stessa anziché a
 *                    un'istanza specifica della classe e possono essere chiamati
 *                    senza creare un'istanza della classe. Nel Singleton pattern,
 *                    il metodo getInstance() è spesso dichiarato come statico
 *                    perché deve essere accessibile globalmente e deve restituire
 *                    l'istanza singleton senza dover creare una nuova istanza della classe.
 *
 * In breve, l'uso di variabili e metodi statici nel Singleton pattern è una
 * pratica comune per garantire che ci sia una sola istanza della classe
 * e per fornire un punto di accesso globale a tale istanza.
 */

/**
 * 1) private static UserIdsGenerator instance = null;:
 *    Questa riga dichiara una variabile statica instance di tipo UserIdsGenerator,
 *    che conterrà l'unica istanza della classe.
 *    La variabile è inizializzata a null finché non viene creata un'istanza della classe.
 *
 * 2) private int lastId;:
 *    Questa riga dichiara una variabile lastId che tiene traccia dell'ultimo ID generato.
 *    È una variabile di istanza e verrà inizializzata a 0 dal costruttore.
 *
 * 3) private UserIdsGenerator() { ... }: Questo è il costruttore privato della classe.
 *    È privato per impedire la creazione di istanze della classe al di fuori della
 *    classe stessa. Inizializza lastId a 0.
 *
 * 4) public int generateId() { ... }: Questo è il metodo generateId() che viene
 *    utilizzato per generare un nuovo ID. Incrementa lastId di uno e restituisce
 *    il nuovo valore.
 *
 * 5) public static UserIdsGenerator getInstance() { ... }:
 *    Questo è il metodo statico getInstance() che restituisce l'istanza singleton
 *    della classe. Controlla se l'istanza è già stata creata. Se non lo è, ne crea
 *    una nuova e la memorizza nella variabile instance. Infine, restituisce l'istanza.
 */
public class UserIdsGenerator {
    /** Variabile statica che conterrà l'istanza unica della classe
     * inizializzata a null per il controllo*/
    private static UserIdsGenerator instance = null;
   /** variabile che conterrà l'ultimo ID creato*/
    private int                     lastId;


    /**********************COSTRUTTORE PRIVATO*********************************
     * il costruttore, essendp privato, non potrà creare istanze direttamente
     * dalla classe al di fuori di essa stessa*/
    private UserIdsGenerator() {

        this.lastId = 0;

    }

    /********************METODO PER GENERARE UNNUOVO ID***********************
     * Prendo l'ultimo id generato, lo incremento e lo restituisco */
    public int generateId() {

        return (++this.lastId);

    }

    /*************METODO PER OTTENERE L'ISTANZA GENERATA***********************
     * Se non esiste crea l'istanza e la restituisce
     * */

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
}