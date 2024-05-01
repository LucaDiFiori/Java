/**CREAZIONE DELL'INTERFACCIA USERLIST*/
interface UsersList {
    /**Metodo per l'aggiunta di un utente
     * param: tipo -> Usure class
     *         aggiunge l'utente u all'array */
    public void addUser(User u);

    /**Metodo per cercare un utente nell'array tramite ID
     * param: tipo -> int
     *         ID dell'utente da cercare
     * return : tipo -> User class
     *           Utente corrispondente all'ID*/
    public User searchById (int id);

    /**Metodo per cercare un utente nell'array tramite indice
     * param: tipo -> int
     *         indice dell'array
     * return : tipo -> User class
     *           Utente corrispondente all'indice*/
    public User searchByindex (int index);

    /**Metodo per avere il numero di users totali (o grandezza dell'array)
     * return : tipo -> int
     *           dimensione dell'indice*/
    public int listSize ();

    /******************************ECCEZIONE*******************************
     * CLASS EXCEPTION: public class Exception extends Throwable
     *
     In Java, Exception è una classe base per tutte le eccezioni controllate.
     Le eccezioni controllate sono quelle che devono essere gestite nel codice,
     ad esempio con un blocco try-catch, o devono essere dichiarate nella firma
     del metodo usando la clausola throws.

     La classe Exception si trova nel package java.lang ed estende la classe
     Throwable. Essa rappresenta situazioni anomale che si verificano durante
     l'esecuzione di un programma Java.
     *
     *La classe base per tutte le eccezioni è java.lang.Exception. Questa classe
     * è la superclasse di tutte le altre eccezioni definite in Java. Puoi usare
     * Exception direttamente per creare eccezioni generiche,
     * oppure puoi sottoclassificarla per creare nuovi tipi di eccezioni più specifiche.
     *
     *
     * Le eccezioni in Java possono essere divise in due categorie principali:
     * - ECCEZIONI CONTROLLATE (checked exceptions):
     *   Le eccezioni controllate sono quelle che devono essere gestite nel codice.
     *   Questo significa che il compilatore Java ti richiederà di gestire queste
     *   eccezioni, altrimenti il codice non compilerà.
     *   La gestione delle eccezioni può avvenire mediante l'utilizzo di un blocco
     *   try-catch, dove il blocco try contiene il codice che potrebbe lanciare un'eccezione,
     *   e il blocco catch cattura e gestisce l'eccezione.
     *
     *
     * - e ECCEZIONI NON CONTROLLATE (unchecked exceptions).
     *   Le eccezioni non controllate, d'altra parte, sono eccezioni che estendono la classe
     *   RuntimeException o una delle sue sottoclassi. Queste eccezioni non sono obbligate
     *   ad essere gestite e il compilatore non impone di farlo.
     *   Solitamente derivano da errori nel codice o da situazioni impreviste durante
     *   l'esecuzione del programma.
     *
     *   Le eccezioni non controllate in Java sono quelle che derivano da RUNTIMEEXCEPTION
     *   o da una delle sue sottoclassi.
     *   Alcune delle eccezioni non controllate più comuni includono:
     *
     *   NullPointerException: Lanciata quando si tenta di accedere o di fare operazioni
     *                         su un oggetto che è null.
     *   ArrayIndexOutOfBoundsException: Lanciata quando si tenta di accedere a un indice
     *                                   di un array che è al di fuori dei suoi limiti.
     *   ClassCastException: Lanciata quando si tenta di eseguire un'operazione di cast tra
     *                       tipi che non sono compatibili.
     *   NumberFormatException: Lanciata quando si tenta di convertire una stringa in un
     *                          numero, ma la stringa non ha un formato numerico valido.
     *   ArithmeticException: Lanciata quando si verifica un errore aritmetico, come una
     *                        divisione per zero.
     *   IllegalArgumentException: Lanciata quando viene passato un argomento non valido a
     *                             un metodo.
     *   IllegalStateException: Lanciata quando lo stato di un oggetto non è adatto per
     *                          l'operazione richiesta.
     *   UnsupportedOperationException: Lanciata quando si tenta di eseguire un'operazione
     *                                  non supportata.
     *
     *
     *
     * RUNTIMEEXCEPTION
     * è una classe base per tutte le eccezioni non controllate in Java. Le eccezioni non
     * controllate estendono direttamente RuntimeException o una delle sue sottoclassi.
     * Queste eccezioni non sono obbligate a essere gestite esplicitamente nel codice,
     * ma possono essere catturate e gestite se necessario.
     *
     * Quando viene lanciata un'eccezione di tipo RuntimeException, il flusso di esecuzione
     * del programma viene interrotto e il controllo passa al contesto più esterno che ha un
     * blocco try-catch per gestire l'eccezione. Se nessun blocco try-catch gestisce
     * l'eccezione, l'eccezione risale la pila delle chiamate fino a raggiungere il
     * contesto di esecuzione globale, dove il thread che esegue il programma termina e
     * viene mostrato un messaggio di errore.
     *
     * SUPER(MESSAGE)
     * è un'espressione che chiama il costruttore della classe genitore (superclasse) e
     * passa un parametro message al costruttore della superclasse.
     *
     * Nel contesto del costruttore della classe UserNotFoundException, super(message)
     * viene utilizzato per chiamare il costruttore della superclasse RuntimeException e
     * passare un messaggio che descrive l'eccezione. La classe RuntimeException ha un
     * costruttore che accetta una stringa come argomento, il quale viene utilizzato per
     * fornire informazioni aggiuntive sull'eccezione.
     * */


    /**Creo la mia classe UserNotFoundException estesa con RuntimeException
     * Cosa fa: Chiama il costruttore di RuntimeException passandogli l'errore*/
    public class UserNotFoundException extends RuntimeException {
        //costruttore che prende in input un messaggio d'errore
        public UserNotFoundException(String error) {
            super(error);
        }
    }
}