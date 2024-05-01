import java.util.UUID;

public class Transaction {

    static enum TransCategory {
        OUTCOME,
        INCOME
    }

    private UUID id;
    private User recipient;
    private User sender;
    private TransCategory tCat;
    private double amount;


    /*_______________________________COSTRUCTOR_______________________________*/
    public Transaction(User rec, User send, TransCategory cat, double amt) {
        this.id = UUID.randomUUID();
        this.recipient = rec;
        this.sender = send;
        this.tCat = cat;
        if ((cat == TransCategory.INCOME && amt < 0 
            || cat == TransCategory.OUTCOME && amt > 0)
            || (cat == TransCategory.OUTCOME && this.sender.getBalance() < amt)
            || (cat == TransCategory.INCOME && this.recipient.getBalance() < amt))
        {
            System.err.println("Invalid transaction\n");
            System.exit(1);
        }
        this.amount = amt;

        // Add the transaction to both users' transaction lists
        //"this" argument is the transaction object that is being created whithin the constructor
        this.recipient.addTransaction(this); 
        this.sender.addTransaction(this);
    }

   /*__________________________________METHODS________________________________*/
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

    @Override
    public String toString() {
        return ("Transaction id =" + id + "\n" +
                "Recipient = " + recipient.getName() + "\n" +
                "Sender = " + sender.getName() + "\n" +
                "Transfer Ammount = " + amount + "\n" +
                "Category = " + tCat +"\n");
    }
}

