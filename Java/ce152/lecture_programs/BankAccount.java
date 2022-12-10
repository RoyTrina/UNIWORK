package lectures_programs;

public abstract class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public final String getAccountNumber() {
        return accountNumber;
    }

    public final double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return accountNumber + ": " + balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || balance < amount)
            return false;
        balance -= amount;
        return true;
    }

    public abstract void monthEnd();
}
