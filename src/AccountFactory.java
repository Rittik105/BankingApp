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

    public Account getNewAccount(String accInfo) {
        String[] infoArray = accInfo.split("  ");
        String accType = infoArray[0];
        int accNo = Integer.parseInt(infoArray[1]);
        String accName = infoArray[2];

        if(accType.equalsIgnoreCase("Savings")){
            return new SavingsAccount(accNo, accName);
        }
        else if (accType.equalsIgnoreCase("Current")) {
            return new CurrentAccount(accNo, accName);
        }
        else if (accType.equalsIgnoreCase("Salary")) {
            return new SalaryAccount(accNo, accName);
        }
        else {
            return null;
        }
    }
}
