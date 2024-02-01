import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankUI ui = new BankUI(bank);

        ui.showWelcomeMessage();

        String choice;
        Scanner scanner = new Scanner(System.in);
        do{
            ui.showMenu();
            choice = scanner.next();

            switch (choice) {
                case "1": {
                    ui.createAccountUI();
                    break;
                }
                case "2": {
                    ui.displayAllAccountsUI();
                    break;
                }
                case "3": {
                    ui.updateAccountUI();
                    break;
                }
                case "4": {
                    ui.deleteAccountUI();
                    break;
                }
                case "5": {
                    ui.depositUI();
                    break;
                }
                case "6": {
                    ui.withdrawUI();
                    break;
                }
                case "7": {
                    ui.searchUI();
                    break;
                }
                case "8": {
                    ui.showExitMessage();
                    break;
                }
                default: {
                    ui.showInvalidChoiceMessage();
                }
            }
        }
        while(!choice.equals("8"));

        scanner.close();
    }
}
