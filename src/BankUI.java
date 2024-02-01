import java.util.ArrayList;
import java.util.Scanner;

public class BankUI {
    private Bank bank;
    public BankUI(Bank bank){
        this.bank = bank;
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
    public void createAccount(){
        Scanner scanner = new Scanner(System.in);

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
        System.out.print("Enter Contact: ");
        String contact = scanner.next();

        System.out.println();
        System.out.println("Creating Account...");

        int accNo = bank.openNewAccount(accType, accName, contact);
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
    public void displayAllAccounts(){
        System.out.println("Displaying all account info.");
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
    public void showExitMessage() {
        System.out.println("Exiting the app...");
    }
    public void showInvalidChoiceMessage(){
        System.out.println("Not a valid option. Please enter a valid option.");
    }

}
