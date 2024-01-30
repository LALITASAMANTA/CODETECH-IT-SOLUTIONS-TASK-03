import java.util.Scanner;

public class AtmDetails {
    private Accountclass userAccount;

    public AtmDetails(Accountclass userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processTransaction(int balance) {
    try (Scanner scanner = new Scanner(System.in)) {
        switch (balance) {
            case 1:
                System.out.println("Current Balance: $" + userAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New Balance: $" + userAccount.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful. New Balance: $" + userAccount.getBalance());
                }
                break;
            case 4:
                System.out.println("Exits. Thank you!");
                break;
            default:
                System.out.println("Invalid. Please choose a valid option.");
        }
    }
    }

    public static void main(String[] args) {
        Accountclass userAccount = new Accountclass(1000); // Initial balance $1000
        AtmDetails atm = new AtmDetails(userAccount);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                atm.displayOptions();
                System.out.print("Choose an option: ");
                int balance = scanner.nextInt();
                atm.processTransaction(balance);
            }
        }
    }
}
