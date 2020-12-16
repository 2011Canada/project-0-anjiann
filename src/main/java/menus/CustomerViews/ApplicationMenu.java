package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import services.AccountService;
import services.ServiceProvider;

public class ApplicationMenu extends Menu {
	AccountService accountService = ServiceProvider.getInstance().getAccountService();

	@Override
	public void manageUserInput() {
		// TODO Auto-generated method stub
		System.out.println("Which type of account would you like to apply for: ");
		System.out.println("1) Chequing");
		System.out.println("2) Savings");
		String accountName = "Chequing";
		try {
			String input = userInput.nextLine();
			int choice = Integer.parseInt(input) - 1;
			switch(choice) {
				case 0: accountName = "Chequing"; break;
				case 1: accountName = "Savings"; break;
				default: throw new NumberFormatException();
			}
		} catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	
		try {
			System.out.println("Please enter your initial deposit amount:");
			System.out.print("$");
			String input = userInput.nextLine();
			double initialAmount = Double.parseDouble(input);
			accountService.createAccount(accountName, BankLauncher.getCurrentUser(), initialAmount);
			BankLauncher.menuSelector.returnToPrevious();
		} catch(NumberFormatException e) {
			System.out.println("Not a valid dollar amount. Try again");
		}
	}

}
