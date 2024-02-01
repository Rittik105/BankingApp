import java.util.ArrayList;
import java.util.Scanner;

public class BankUI {
    private Bank bank;
    private Scanner scanner;

    public BankUI(Bank bank){
        this.bank = bank;
        scanner = new Scanner(System.in);
    }
    public void showWelcomeMessage(){
        System.out.print("Welcome to my banking app!!");
    }
    public void showMenu(){
        System.out.println();
        System.out.println("Choose An Option:");
        System.out.println("1. Open an account");
        System.out.println("2. Display all accounts");
        System.out.println("3. Update an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Deposit to your account");
        System.out.println("6. Withdraw from your account");
        System.out.println("7. Search for an account");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Option:");
    }
    public void createAccountUI(){
        System.out.println();
        System.out.println("Choose Account Type:");
        System.out.println("1. Savings account");
        System.out.println("2. Current accounts");
        System.out.println("3. Salary account");
        System.out.println();
        System.out.print("Option: ");
        int accType = scanner.nextInt();

        System.out.println();
        System.out.print("Enter Account Name: ");
        String accName = scanner.next();

        System.out.println();
        System.out.println("Creating Account...");

        int accNo = bank.openNewAccount(accType, accName);
        if(accNo < 0){
            System.out.println("Account opening failed.");
            return;
        }

        System.out.println("Account opened successfully. Your Account No is: " + accNo);
        System.out.println("You need to make a initial deposit. Minimum Balance is: " + bank.getMinBalance(accNo));
        while(true){
            System.out.print("Enter deposit amount: ");
            float iniDeposit = scanner.nextFloat();
            boolean success = bank.depositInitialAmount(accNo, iniDeposit);
            if(success){
                System.out.println("Deposit successful.");
                System.out.println("Your balance: " + bank.getBalance(accNo));
                break;
            }
            else{
                System.out.println("Amount is lower than minimum balance");
            }
        }
    }
    public void displayAllAccountsUI(){
        System.out.println("Displaying all account info...");
        ArrayList<String> accInfos = new ArrayList<>();

        accInfos = bank.getAllAccountInfo();
        if(accInfos == null){
            System.out.println("Encountered an error");
            return;
        }
        for(String info : accInfos){
            System.out.println(info);
        }
    }
    public void updateAccountUI(){
        System.out.print("Enter Account No: ");
        int accNo = scanner.nextInt();
        System.out.println("New Account Name: ");
        String newName = scanner.next();

        bank.updateAccountInfo(accNo, newName);
    }
    public void deleteAccountUI(){
        System.out.print("Enter Account Code: ");
        int accNo = scanner.nextInt();
        System.out.println("Are you sure you want to delete " + accNo + "?(y/n)");
        String choice = scanner.next();
        if(choice.equalsIgnoreCase("y")){
            bank.deleteAccount(accNo);
            System.out.println("Account deleted");
        }
    }
    public void depositUI(){
        System.out.print("Enter Account No: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Amount to deposit: ");
        float amount = scanner.nextFloat();
        bank.depositAmount(accNo, amount);
        System.out.println("Deposit successful. New balance: "+bank.getBalance(accNo));
    }
    public void withdrawUI(){
        System.out.print("Enter Account No: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter Amount to withdraw: ");
        float amount = scanner.nextFloat();
        if(bank.withdrawAmount(accNo, amount)){
            System.out.println("Withdrawal successful. New balance: " + bank.getBalance(accNo));
        }
        else{
            System.out.println("Withdrawal denied. Account balance would be less than minimum balance.");
        }
    }
    public void searchUI(){
        System.out.println("Enter account no for searching: ");
        int accNo = scanner.nextInt();
        String accInfo = bank.getAccountInfo(accNo);
        if(accInfo.isEmpty()){
            System.out.println("Account was not found");
            return;
        }

        System.out.println("Account found.");
        System.out.println(accInfo);
    }
    public void showExitMessage() {
        System.out.println("Exiting the app...");
    }
    public void showInvalidChoiceMessage(){
        System.out.println("Not a valid option. Please enter a valid option.");
    }

}
