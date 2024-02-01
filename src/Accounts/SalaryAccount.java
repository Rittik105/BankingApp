package Accounts;

public class SalaryAccount extends Account{
    public SalaryAccount(int accountNo, String accountName, String contactNo) {
        super(accountNo, accountName, contactNo);
        setMinBalance(1000);
    }
}
