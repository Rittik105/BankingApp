import java.io.*;
import java.util.ArrayList;
import Accounts.Account;

public class Bank {
    ArrayList<Account> accounts;

    public Bank(){
        accounts = new ArrayList<>();
        loadFromFile();
    }

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

    public boolean depositAmount(int accNo, float amount){
        Account account = searchForAccount(accNo);

        if (account != null){
            account.deposit(amount);
            return true;
        }

        return false;
    }

    public float getBalance(int accNo){
        Account account = searchForAccount(accNo);
        return account.getBalance();
    }

    public boolean updateAccountInfo(int accNo, String newName) {
        Account account = searchForAccount(accNo);
        if(account != null) {
            account.setAccountName(newName);
            return true;
        }

        return false;
    }

    public boolean deleteAccount(int accNo) {
        Account account = searchForAccount(accNo);
        if(account == null || !account.getIsActive())
            return false;

        account.setIsActive(false);
        return true;
    }

    public int withdrawAmount(int accNo, float amount) {
        Account account = searchForAccount(accNo);
        if (account != null){
            if(account.withdraw(amount)){
                return 1;
            }

            return 0;
        }

        return  -1;
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

    public void loadFromFile(){
        File file = new File("src/accounts.txt");
        AccountFactory accountFactory = new AccountFactory();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Account account = accountFactory.getNewAccount(line);
                accounts.add(account);
            }
        } catch (IOException e) {
            System.err.println("Error loading accounts from file: " + e.getMessage());
        }

    }

    public void saveToFile() {
        File file = new File("src/accounts.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Account account : accounts) {
                writer.write(account.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving accounts to file: " + e.getMessage());
        }
    }
}
