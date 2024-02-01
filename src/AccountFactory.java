import Accounts.Account;
import Accounts.CurrentAccount;
import Accounts.SalaryAccount;
import Accounts.SavingsAccount;

public class AccountFactory {
    public Account getNewAccount(int accType, int accNo, String accName, String contact) {
        if(accType == 1){
            return new SavingsAccount(accNo, accName, contact);
        }
        else if (accType == 2) {
            return new CurrentAccount(accNo, accName, contact);
        }
        else if (accType == 3) {
            return new SalaryAccount(accNo, accName, contact);
        }
        else {
            return null;
        }
    }
}
