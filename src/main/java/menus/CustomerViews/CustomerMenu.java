package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import services.AccountService;
import services.UserService;

public class CustomerMenu extends Menu {
	@Override
	public void manageUserInput() {
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
				System.out.println("Which account would you like to access:");
				System.out.println("1) " + account.getName());
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input);
				if(choice != 1) {
					throw new NumberFormatException();
				}
				BankLauncher.menuSelector.moveToSubMenu(1);
				System.out.println("your account application has been submitted.");
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}
}
