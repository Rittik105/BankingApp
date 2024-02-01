package Accounts;

public class CurrentAccount extends Account{
    public CurrentAccount(int accountNo, String accountName, String contactNo) {
        super(accountNo, accountName, contactNo);
        setMinBalance(200);
    }
}
