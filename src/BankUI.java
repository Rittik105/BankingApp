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
        System.out.println("3. Update an ccount");
        System.out.println("4. Delete an account");
        System.out.println("5. Deposit to your account");
        System.out.println("6. Withdraw from your account");
        System.out.println("7. Search for an account");
        System.out.println("8. Exit");
        System.out.println();
        System.out.print("Option:");
    }

    public void showExitMessage() {
        System.out.println("Exiting the app...");
    }
    public void showInvalidChoiceMessage(){
        System.out.println("Not a valid option. Please enter a valid option.");
    }

}
