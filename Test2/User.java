
public class User {

    private int balance;
    private int id;

    public User(int id, int amount) {
        if (amount < 0 || id < 0) {
            throw new IllegalArgumentException("Invalid input: Values can't be a negative numbers!");
        }
        this.balance = amount;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getBalance() {
        return this.balance;
    }

    public void makePurchase(int amount) {
        this.balance -= amount;
    }
}
