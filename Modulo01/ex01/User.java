public class User {
    private int id;
    private String name;
    private double balance;

    /*******************CREO IL COSTRUTTORE default********************/
    public User() {
        this.id = 0;
        this.name = "Unnamed User";
        balance = 0.0;
    }

    /*************************CREO IL COSTRUTTORE*****************************/
    public User(String name, double balance) {
        /**
         * Scrivendo cosi prima verrà chiamato il metodo getInstance() che, se non esiste,
         * crea l'istanza e poi chiama il metodo generateId() per creare un nuovo ID ogni volta
         */
        this.id = UserIdsGenerator.getInstance().generateId();
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

    /***********************************STAMPA CAMPI*****************************/
    @Override
    public String toString() {
        return ("User ID: " + getId() + "\n" +
                "Account Name: " + getName() + "\n" +
                "Balance: " + getBalance());
    }
}