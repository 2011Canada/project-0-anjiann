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
		System.out.println("Please enter your initial deposit amount:");
		System.out.print("$");
		String input = userInput.nextLine();
		try {
			double initialAmount = Double.parseDouble(input);
			accountService.createAccount(BankLauncher.getCurrentUser(), initialAmount);
			BankLauncher.menuSelector.returnToPrevious();
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
