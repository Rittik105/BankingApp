package Accounts;

public abstract class Account {
    private int accountNo;
    private String accountName;
    private String contactNo;
    private float balance;
    private float minBalance;
    private String accountType;

    public Account(int accountNo, String accountName, String contactNo, String accountType){
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.contactNo = contactNo;
        this.accountType = accountType;
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
    public String getAccountType() {
        return accountType;
    }
    public void deposit(float amount){
        this.balance += amount;
    }
    @Override
    public String toString(){
        return accountType +"\t"+ accountNo + "\t" + accountName + "\t" + contactNo;
    }
}
