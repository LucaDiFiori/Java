public class Program {
    public static void main(String[] args) {
        User user1 = new User("Ber_nome", 150.0);

        System.out.println(user1);

        for (int i = 0; i < 10; i++)
        {
            user1 = new User("Ber_nome", 150.0);
            System.out.println(user1);
        }
    }
}