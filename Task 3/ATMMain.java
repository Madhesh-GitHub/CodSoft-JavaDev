import java.util.Scanner;

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\n===== ATM Menu =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void checkBalance() {
        System.out.println("Hello " + bankAccount.getAccountHolderName() + ", your current balance is: $" + bankAccount.getBalance());
    }
}


class BankAccount {
    private String accountHolderName; 
    private double balance; 

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}



public class ATMMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your Name to create a Bank Account: ");
        String userName = scanner.nextLine();

        System.out.println("Enter the initial deposit amount (minimum 1000): ");
        double initialDeposit = scanner.nextDouble();
        if (initialDeposit < 1000) {
            System.out.println("Initial deposit must be at least 1000. Account creation failed.");
            return; 
        }

        BankAccount userAccount = new BankAccount(userName, initialDeposit);
        System.out.println("Account created successfully for " + userAccount.getAccountHolderName() + "!");
        ATM atm = new ATM(userAccount);
        boolean exit = false;
        while (!exit) {
            atm.displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM, " + userAccount.getAccountHolderName() + ". Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
