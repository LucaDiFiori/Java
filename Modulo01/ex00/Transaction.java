import java.util.UUID;

public class Transaction {

    /**
     * in Java, l'enum è una classe speciale che rappresenta un tipo di
     * dato che consiste in un insieme fisso di costanti. Ogni costante
     * all'interno di un'enumerazione è un'istanza dell'enumerazione stessa.
     *
     * In quanto classe la definirò static per usarla qui semza dover creare
     * un istanza
     */
    static enum TransCategory {
        OUTCOME,
        INCOME
    }

    /**
     * NOTA: uuid
     * UUID è un tipo/classe usato per generare codici univochi
     */
    private UUID id; //codice della transazione
    private User recipient; //variabile per il ricevente di tipo "classe User"
    private User sender;
    private TransCategory tCat; //Variabile di tipo "Classe Trans..
    private double amount; // variabile per la cifra


    /*******************************COSTRUTTORE*****************************/
    public Transaction(User rec, User send, TransCategory cat, double amt) {
        this.id = UUID.randomUUID();
        this.recipient = rec;
        this.sender = send;
        this.tCat = cat;
        if ((cat == TransCategory.INCOME && amt < 0 || cat == TransCategory.OUTCOME && amt > 0)
                || (cat == TransCategory.OUTCOME && this.sender.getBalance() < amt)
                || (cat == TransCategory.INCOME && this.recipient.getBalance() < amt))
        {
            System.err.println("Invalid transaction\n");
            System.exit(1);
        }
        this.amount = amt;
    }

    /**************************FUNZIONI PER LEGGERE I CAMPI****************/
    public UUID getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public double getAmount() {
        return amount;
    }

    public TransCategory getCategory() {
        return tCat;
    }

/***********************************STAMPA CAMPI****************************/
    @Override
    public String toString() {
        return ("Transaction id =" + id + "\n" +
                "Recipient = " + recipient.getName() + "\n" +
                "Sender = " + sender.getName() + "\n" +
                "Transfer Ammount = " + amount + "\n" +
                "Category = " + tCat +"\n");
    }
}

