package Accounts;

public abstract class Account {
    private int accountNo;
    private String accountName;
    private String contactNo;
    private float balance;
    private float minBalance;

    public Account(int accountNo, String accountName, String contactNo){
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.contactNo = contactNo;
        this.balance = 0;
    }

    protected void setMinBalance(float minBalance) {
        this.minBalance = minBalance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public float getBalance() {
        return balance;
    }

    public float getMinBalance() {
        return minBalance;
    }

    public void deposit(float amount){
        this.balance += amount;
    }
}
