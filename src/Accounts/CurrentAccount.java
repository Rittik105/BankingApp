package Accounts;

public class CurrentAccount extends Account{
    public CurrentAccount(int accountNo, String accountName) {
        super(accountNo, accountName, "Current");
        setMinBalance(200);
    }
}
