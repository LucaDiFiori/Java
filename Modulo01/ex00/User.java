public class User {
    private int id;
    private String name;
    private double balance;

    /*******************CREO IL COSTRUTTORE default********************
     * Questo sarà il costruttore utilizzato in caso non gli vengano passati
     * argomenti al momento delle creazione di un nuovo oggetto
     *
     * "this." serve nel momento della creazione di un nuovo oggetto.
     *         Significa che i campi (variabili) del NUOVO OGGETTO CREATO
     *         saranno inizializzate con quei valori.
     *
     *         this viene utilizzato all'interno del costruttore della
     *         classe User per fare riferimento agli attributi dell'istanza
     *         corrente della classe
     *
     *         Avrei potuto anche non usare this e scrivere direttamente "id = 0"
     *         La ragione principale per utilizzare this nel costruttore è per
     *         chiarire che stai facendo riferimento agli attributi della classe
     *         anziché a variabili locali o parametri dei metodi.
     */
    public User() {
        this.id = 0;
        this.name = "Unnamed User";
        balance = 0.0;
    }

    /*************************CREO IL COSTRUTTORE*****************************
     * Questo è il costruttore che verrà usato quando gli passo degli argomenti.ù
     *
     * Le variabili che il costruttore ha come argomento saranno quelli con cui
     * verrannp inizializzati i campi dell'oggetto creato
     *
     * NOTA: Ho quindi costruito due metodi costruttori con lo stesso nome.
     *       Quale dei due verrà usato sarà scelto automaticamente dal programma
     *       in base agli argomenti: Se non ne passo usa il primo, se li passo
     *       usa il secondo
     */
    public User(int id, String name, double balance) {
        this.id = id;  /**NOTA: Qui posso vedere l'uso di "this. Sto assegnando
         al campo "id" della classe una variabile locale
         che ha lo stesso nome "id"*/
        this.name = name;
        if (balance < 0) {
            System.out.println("Invalid balance. Default balance set to 0");
            balance = 0;
        }
        else {
            this.balance = balance;
        }
    }

    /*************************METODI PER LEGGERE I CAMPI**********************/
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    /*************************METODI PER ASSEGNARE I CAMPI**********************/
    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /***********************************STAMPA CAMPI****************************
     * Metodo che andrà a stampare i campi dell'utente
     *
     * NOTA: @override
     * L'override in Java si riferisce alla pratica di fornire una nuova implementazione
     di un metodo che è già definito nella classe genitore (superclasse).

     In sostanza, l'override ti consente di personalizzare il comportamento di un metodo
     ereditato dalla superclasse per adattarlo alle esigenze della tua classe sottoclasse.

     Qui sotto il metodo toString() della classe corrente sta sovrascrivendo il
     metodo toString() della classe genitore (Object).
     Il metodo ridefinito restituisce una stringa che rappresenta lo stato
     dell'oggetto corrente in base agli attributi dell'istanza (ID, nome e saldo dell'account).


     * NOTA: toString
     Il metodo toString() appartiene alla classe Object.
     Questo metodo è comunemente utilizzato per ottenere una rappresentazione in formato
     stringa di un oggetto.

     Quando chiami il metodo toString() su un oggetto, di default, restituisce una stringa
     che contiene il nome della classe dell'oggetto seguito
     da un segno '@' e l'hash code dell'oggetto, come ad esempio "NomeClasse@hashcode".
     */
    @Override
    public String toString() {
        return ("User ID: " + getId() + "\n" +
                "Account Name: " + getName() + "\n" +
                "Balance: " + getBalance());
    }
}