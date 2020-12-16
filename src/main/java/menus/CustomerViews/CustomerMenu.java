package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import services.AccountService;
import services.UserService;

public class CustomerMenu extends Menu {
	@Override
	public void manageUserInput() {
		System.out.println("Please enter the option number");
		Account account = accountService.findAccount(BankLauncher.getCurrentUser().getUserId());
		try {
			if(account == null) {
				System.out.println("1) apply for account");
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input);
				if(choice != 1) {
					throw new NumberFormatException();
				}
				BankLauncher.menuSelector.moveToSubMenu(0);
			} else {
				System.out.println("1) " + account.getName());
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input);
				if(choice != 1) {
					throw new NumberFormatException();
				}
				BankLauncher.menuSelector.moveToSubMenu(1);
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}
}
