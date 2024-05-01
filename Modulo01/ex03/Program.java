public class Program {
    public static void main(String[] args) {
        
    User john = new User("John", 1000);
    System.out.println("John: " + john);
    System.out.println("");
    User mike = new User("Mike", 2000);
    System.out.println("Mike: " + mike);
    System.out.println("");
    User joe = new User("Joe", 3000);
    System.out.println("Joe: " + joe);

    
    
    System.out.println("");
    System.out.println("_____________________TRANSACIONS:__________________");
    
    Transaction transaction1 = new Transaction(john, mike,
        Transaction.TransCategory.INCOME, 500);
    System.out.println("John TRANSACTION: " + "\n" + transaction1);
    if (john.getTransList() != null)
    {
        System.out.print("John Transaction LIST: " + "\n");
        john.getTransList().printList();
    }
    else{
        System.out.println("John Transaction LIST: "
            + "Empty Transaction List");
    }
    
    
    
    System.out.println("--------------------------------");
    Transaction transaction2 = new Transaction(mike, joe,
        Transaction.TransCategory.OUTCOME, -1000);
    System.out.println("Mike TRANSACTION: " + "\n" + transaction2);
    if (mike.getTransList() != null)
    {
        System.out.print("Mike Transaction LIST: " + "\n");
        mike.getTransList().printList();
    }
    else{
        System.out.println("Mike Transaction LIST: "
            + "Empty Transaction List");
    }
    
    
    
    System.out.println("--------------------------------");
    Transaction transaction3 = new Transaction(joe, john,
        Transaction.TransCategory.OUTCOME, -1500);
    System.out.println("Joe TRANSACTION: " + "\n" + transaction3);
    if (joe.getTransList() != null)
    {
        System.out.print("Joe Transaction LIST: " + "\n");
        joe.getTransList().printList();
    }
    else{
        System.out.println("Joe Transaction LIST: "
            + "Empty Transaction List");
    }
    System.out.println("--------------------------------");
}
}