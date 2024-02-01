package Accounts;

public class SalaryAccount extends Account{
    public SalaryAccount(int accountNo, String accountName) {
        super(accountNo, accountName, "Salary");
        setMinBalance(1000);
    }
}
