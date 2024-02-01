import java.util.ArrayList;
import Accounts.Account;

public class Bank {
    ArrayList<Account> accounts = new ArrayList<>();

    public int openNewAccount(int accType, String accName, String contact) {
        int accNo = accounts.size() + 10000;

        AccountFactory factory = new AccountFactory();
        Account newAcc = factory.getNewAccount(accType, accNo, accName, contact);
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
}
