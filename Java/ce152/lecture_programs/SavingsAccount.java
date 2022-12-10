package lectures_programs;

public class SavingsAccount extends BankAccount {

    static final double interestRate = 0.5;
    private double minBalance;

    public SavingsAccount(String accountNumber, double initialDeposit) {
        super(accountNumber);
        this.deposit(initialDeposit);
        this.minBalance = initialDeposit;
    }

    public double getMinBalance() {
        return minBalance;
    }

    @Override
    public String toString() {
        return "SavingsAC(" + super.toString() + ", minBalance=" + minBalance + ")";
    }

    @Override
    public boolean withdraw(double amount) {
        boolean ok = super.withdraw(amount);
        if (!ok) return false;
        double balance = getBalance();
        if (balance < minBalance) minBalance = balance;
        return true;
    }

    @Override
    public void monthEnd() {
        this.deposit(minBalance * interestRate / 100);
        minBalance = getBalance();
    }

}
