import java.util.ArrayList;
import Accounts.Account;

public class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    public int openNewAccount(int accType, String accName) {
        int accNo = accounts.size() + 10000;

        AccountFactory factory = new AccountFactory();
        Account newAcc = factory.getNewAccount(accType, accNo, accName);
        if(newAcc == null){
            return -1;
        }

        accounts.add(newAcc);
        return newAcc.getAccountNo();
    }

    public float getMinBalance(int accNo){
        Account account = searchForAccount(accNo);

        if(account != null){
            return account.getMinBalance();
        }

        return -1;
    }

    public Account searchForAccount(int accNo){
        for (Account account : accounts) {
            if (account.getAccountNo() == accNo) {
                return account;
            }
        }

        return null;
    }

    public boolean depositInitialAmount(int accNo, float iniDeposit) {
        if(getMinBalance(accNo) < iniDeposit){
            depositAmount(accNo, iniDeposit);
            return true;
        }

        return false;
    }

    public void depositAmount(int accNo, float amount){
        Account account = searchForAccount(accNo);
        account.deposit(amount);
    }

    public float getBalance(int accNo){
        Account account = searchForAccount(accNo);
        return account.getBalance();
    }

    public void updateAccountInfo(int accNo, String newName) {
        Account account = searchForAccount(accNo);
        account.setAccountName(newName);
    }

    public void deleteAccount(int accNo) {
        Account account = searchForAccount(accNo);
        account.setIsActive(false);
    }

    public boolean withdrawAmount(int accNo, float amount) {
        Account account = searchForAccount(accNo);
        return account.withdraw(amount);
    }

    public ArrayList<String> getAllAccountInfo() {
        ArrayList<String> accInfos = new ArrayList<>();

        for(Account account : accounts){
            accInfos.add(account.toString());
        }

        return accInfos;
    }

    public String getAccountInfo(int accNo){
        Account account = searchForAccount(accNo);
        if(account != null)
            return account.toString();
        else
            return "";
    }
}
