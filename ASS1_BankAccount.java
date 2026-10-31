
class BankAccount {
    String depositorName;
    String accountNumber;
    String accountType;
    double balance;

    // Assign initial values
    void assignValues(String name, String accNo,
                      String type, double amount) {
        depositorName = name;
        accountNumber = accNo;
        accountType = type;
        balance = amount;
    }

    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited: Rs. " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: Rs. " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Calculate yearly interest
    double calculateInterest(double rate) {
        return (balance * rate) / 100;
    }

    // Display account details
    void display() {
        System.out.println("\n--- Bank Account Details ---");
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class Main {
    public static void main(String[] args) {

        // Array of 3 bank account objects
        BankAccount[] accounts = new BankAccount[3];

        for (int i = 0; i < 3; i++) {
            accounts[i] = new BankAccount();
        }

        // Assign initial values
        accounts[0].assignValues("Rahul", "101",
                                 "Savings", 10000);
        accounts[1].assignValues("Amit", "102",
                                 "Current", 20000);
        accounts[2].assignValues("Priya", "103",
                                 "Savings", 15000);

        // Perform deposit and withdrawal
        accounts[0].deposit(2000);
        accounts[1].withdraw(5000);
        accounts[2].deposit(3000);

        // Display all account details
        for (int i = 0; i < 3; i++) {
            accounts[i].display();

            System.out.println("Yearly Interest (5%): Rs. "
                    + accounts[i].calculateInterest(5));
        }
    }
}
