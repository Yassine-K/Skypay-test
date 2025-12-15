
import accountservice.AccountService;
import java.util.ArrayList;

public class BankingService implements AccountService {

    private int balance;
    private ArrayList<int[]> history = new ArrayList<>();
    private Dates dates = new Dates();

    public BankingService(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid input: Balance can't be a negative number!");
        }
        this.balance = amount;
        if (amount > 0) {
            history.add(0, new int[]{this.dates.dateAsInt(), amount, this.balance});
        }
    }

    public BankingService() {
        this(0);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.print("Invalid input: Amount must be a positive number!\n");
            return;
        }

        this.balance += amount;
        history.add(0, new int[]{this.dates.dateAsInt(), amount, this.balance});
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) {
            System.out.print("Invalid input: Amount must be a positive number!\n");
            return;
        }
        if (amount > this.balance) {
            System.out.print("Insufficient balance! Current balance: " + this.balance + "\n");
            return;
        }
        this.balance -= amount;
        history.add(0, new int[]{this.dates.dateAsInt(), -1 * amount, this.balance});
    }

    @Override
    public void printStatement() {
        if (this.history.isEmpty()) {
            System.out.print("There are no previous transactions!\n");
            return;
        }
        System.out.print("Date\t\t|| Amount\t|| Balance\n");
        for (int[] subarray : history) {
            int i = 0;
            for (int value : subarray) {
                if (i == 0) {
                    System.out.print(value % 100 + "/" + (value % 10000) / 100 + "/" + value / 10000);
                } else {
                    System.out.print(value);
                }
                if (i == 0) {
                    System.out.print("\t|| ");
                } else if (i == 1) {
                    System.out.print("\t\t|| ");
                }
                i++;
            }
            System.out.println();
        }
    }
}
