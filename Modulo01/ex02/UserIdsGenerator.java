public class UserIdsGenerator {
    private static UserIdsGenerator instance = null;
    private int                     lastId;

    private UserIdsGenerator() {
        this.lastId = 0;
    }

    public int generateId() {
        return (++this.lastId);
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }
}