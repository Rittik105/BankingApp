import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankUI ui = new BankUI(bank);

        ui.showWelcomeMessage();

        int choice;
        Scanner scanner = new Scanner(System.in);
        do{
            ui.showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    ui.createAccount();
                    break;
                }
                case 2: {
                    ui.displayAllAccounts();
                    break;
                }
                case 3: {

                }
                case 4: {

                }
                case 5: {

                }
                case 6: {

                }
                case 7: {

                }
                case 8: {
                    ui.showExitMessage();
                    break;
                }
                default: {
                    ui.showInvalidChoiceMessage();
                }
            }
        }
        while(choice != 8);

        scanner.close();
    }
}
