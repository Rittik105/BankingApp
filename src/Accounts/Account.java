package Accounts;

public abstract class Account {
    private int accountNo;
    private String accountName;
    private float balance;
    private float minBalance;
    private String accountType;
    private boolean isActive;

    public Account(int accountNo, String accountName, String accountType){
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountType = accountType;
        this.balance = 0;
        this.isActive = true;
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
    public float getBalance() {
        return balance;
    }
    public float getMinBalance() {
        return minBalance;
    }
    public String getAccountType() {
        return accountType;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setAccountName(String newName) {
        this.accountName = newName;
    }
    public void setIsActive(boolean b) {
        this.isActive = b;
    }
    public void deposit(float amount){
        this.balance += amount;
    }
    public boolean withdraw(float amount){
        if(this.balance - amount > this.minBalance){
            this.balance -= amount;
            return true;
        }

        return false;
    }
    @Override
    public String toString(){
        return accountType +"\t"+ accountNo + "\t" + accountName;
    }


}
