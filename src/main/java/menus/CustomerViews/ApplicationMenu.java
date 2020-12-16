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
		System.out.println("Please give your account a name:");
		String name = userInput.nextLine();

		System.out.println("Please enter your initial deposit amount:");
		System.out.print("$");
		String input = userInput.nextLine();
		try {
			double initialAmount = Double.parseDouble(input);
			accountService.createAccount(name, BankLauncher.getCurrentUser(), initialAmount);
			BankLauncher.menuSelector.returnToPrevious();
		} catch(NumberFormatException e) {
			System.out.println("Not a valid dollar amount. Try again");
		}
	}

}
