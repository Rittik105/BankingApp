package Accounts;

public class SavingsAccount extends Account{
    public SavingsAccount(int accountNo, String accountName, String contactNo) {
        super(accountNo, accountName, contactNo);
        setMinBalance(500);
    }
}
