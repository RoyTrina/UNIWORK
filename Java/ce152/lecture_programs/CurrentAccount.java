package lectures_programs;

public class CurrentAccount extends BankAccount {

    static final int FREE_WITHDRAWALS = 3;
    static final int WITHDRAWAL_FEE = 1;
    private int withdrawals;

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
        withdrawals = 0;
    }

    public int getWithdrawals() {
        return withdrawals;
    }

    @Override
    public String toString() {
        return "CurrentAC(" + super.toString() + ", withdrawals=" + withdrawals + ")";
    }

    @Override
    public boolean withdraw(double amount) {
        boolean ok = super.withdraw(amount);
        if (!ok) return false;
        if (withdrawals >= FREE_WITHDRAWALS)
            ok = super.withdraw(WITHDRAWAL_FEE);
        if (!ok)
            // undo withdrawal
            super.deposit(amount);
        else
            withdrawals++;
        return ok;
    }

    @Override
    public void monthEnd() {
        withdrawals = 0;
    }

}
