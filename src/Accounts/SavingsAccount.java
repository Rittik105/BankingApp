package Accounts;

public class SavingsAccount extends Account{
    public SavingsAccount(int accountNo, String accountName) {
        super(accountNo, accountName, "Savings");
        setMinBalance(500);
    }
}
