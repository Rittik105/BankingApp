import Accounts.Account;
import Accounts.CurrentAccount;
import Accounts.SalaryAccount;
import Accounts.SavingsAccount;

public class AccountFactory {
    public Account getNewAccount(int accType, int accNo, String accName) {
        if(accType == 1){
            return new SavingsAccount(accNo, accName);
        }
        else if (accType == 2) {
            return new CurrentAccount(accNo, accName);
        }
        else if (accType == 3) {
            return new SalaryAccount(accNo, accName);
        }
        else {
            return null;
        }
    }
}
