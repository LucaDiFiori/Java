public class User {
    private int id;
    private String name;
    private double balance;

    /**COSTRUTTORE default**/
    public User() {
        this.id = 0;
        this.name = "Unnamed User";
        balance = 0.0;
    }

    /**COSTRUTTORE**/
    public User(String name, double balance) {
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

    @Override
    public String toString() {
        return ("User ID: " + getId() + "\n" +
                "Account Name: " + getName() + "\n" +
                "Balance: " + getBalance());
    }
}