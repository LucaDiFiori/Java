import java.util.UUID;

public  interface TransactionsList {
    public void addTransactionHead(Transaction transaction);
    public void addTransactionTail(Transaction transaction);
    public void removeTrasactionById(UUID id);
    public Transaction[] listToArray();

    public class TransactionNotFoundException extends RuntimeException {
        public TransactionNotFoundException(String message) {
            super(message);
        }
    }
}