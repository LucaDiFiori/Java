public class User {
    private int id;
    private String name;
    private double balance;
    private TransactionsLinkedList transList;

/*________________________________CONSTRUCTORS________________________________*/
    public User() {
        this.id = 0;
        this.name = "Unnamed User";
        this.balance = 0.0;
        this.transList = new TransactionsLinkedList();
    }

    public User(String name, double balance) {
        this.name = name;
        if (balance < 0) {
            System.out.println("Invalid balance. Default balance set to 0");
            balance = 0;
        }
        else {
            this.balance = balance;
        }
        this.id = UserIdsGenerator.getInstance().generateId();
        this.transList = new TransactionsLinkedList();
    }


    /*________________________________METHODS_________________________________*/
    public int getId() {

        return id;

    }

    public String getName() {

        return name;

    }

    public double getBalance() {

        return balance;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setBalance(double balance) {

        this.balance = balance;

    }

    public TransactionsLinkedList getTransList() {
        return transList;
    }

    /*"The new transaction will be added at the beginning of the list."t */
    public void addTransaction(Transaction transaction) {
        this.transList.addTransactionHead(transaction);
    }

    @Override
    public String toString() {
        return ("User ID: " + getId() + "\n" +
                "Account Name: " + getName() + "\n" +
                "Balance: " + getBalance());
    }
}