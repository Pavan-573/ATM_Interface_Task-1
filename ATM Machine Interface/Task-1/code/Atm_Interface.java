import java.util.Scanner;

class ATM {
    private double balance;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid deposit amount.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash: ₹" + amount);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(1000); // Starting balance ₹1000

        System.out.println("Welcome to Simple ATM!");
        int option;

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 4);

        scanner.close();
    }
}