
class BankAccount {

    private int balance = 1000;

    // Synchronized deposit method
    synchronized void deposit(int amount) {

        balance = balance + amount;

        System.out.println(
            Thread.currentThread().getName()
            + " deposited Rs. " + amount
            + " | Balance: Rs. " + balance
        );
    }

    // Synchronized withdrawal method
    synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance = balance - amount;

            System.out.println(
                Thread.currentThread().getName()
                + " withdrew Rs. " + amount
                + " | Balance: Rs. " + balance
            );

        } else {

            System.out.println(
                Thread.currentThread().getName()
                + " - Insufficient balance!"
            );
        }
    }

    // Display final balance
    synchronized void displayBalance() {
        System.out.println(
            "\nFinal Balance: Rs. " + balance
        );
    }
}

class DepositThread extends Thread {

    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 3; i++) {
            account.deposit(500);
        }
    }
}

class WithdrawThread extends Thread {

    BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {

        for (int i = 1; i <= 2; i++) {
            account.withdraw(300);
        }
    }
}

public class Main {

    public static void main(String[] args) {

        // Shared bank account
        BankAccount account = new BankAccount();

        // Creating threads
        DepositThread t1 = new DepositThread(account);
        WithdrawThread t2 = new WithdrawThread(account);

        t1.setName("Deposit Thread");
        t2.setName("Withdraw Thread");

        // Starting threads
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
            Thread.currentThread().interrupt();
        }

        // Display final balance
        account.displayBalance();
    }
}
