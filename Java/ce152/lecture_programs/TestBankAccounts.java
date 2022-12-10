package lectures_programs;

import java.util.ArrayList;
import java.util.List;

public class TestBankAccounts {

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new lectures_programs.CurrentAccount("123456789"));
        accounts.add(new SavingsAccount("123456790", 2500));
        accounts.add(new lectures_programs.CurrentAccount("123456791"));
        accounts.get(0).deposit(500);
        accounts.get(1).withdraw(1000);
        accounts.get(2).deposit(200);
        accounts.get(2).withdraw(150);
        for (BankAccount ba : accounts)
            System.out.println(ba);
        BankAccount myBankAccount = new lectures_programs.CurrentAccount("123456795");
        myBankAccount.deposit(22);
    }

}
