
public class Main {

    public static void main(String[] args) {
        try {
            BankingService client = new BankingService(0);
            client.printStatement();
            client.deposit(5000);
            client.withdraw(500);
            client.withdraw(-500);
            client.withdraw(500);
            client.withdraw(6000);
            client.printStatement();
        }
        catch (IllegalArgumentException e) {
            System.out.print(e + "\n");
        }
    }
}
