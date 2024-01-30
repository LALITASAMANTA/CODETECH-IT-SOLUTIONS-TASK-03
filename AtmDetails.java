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
    
    public void processUserInput(int balance) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                displayOptions();
                System.out.print("Enter your choice (1-4): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                        System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                        break;

                    case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                    }
                    break;

                    case 4:
                        System.out.println("Exiting. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }

            } while (choice != 4);
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
                atm.processUserInput(balance);
            }
        }
        
    }
}
