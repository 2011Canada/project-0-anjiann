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
		Account account = accountService.findAccount(BankLauncher.getCurrentUser());
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
				lines.add(() -> "1) view balance");			
				lines.add(() -> "2) withdraw");
				lines.add(() -> "3) deposit");
				lines.add(() -> "4) transfers");
				
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input);
				switch(choice) {
					case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
					case 2: BankLauncher.menuSelector.moveToSubMenu(2); break;
					case 3: BankLauncher.menuSelector.moveToSubMenu(3); break;
					case 4: BankLauncher.menuSelector.moveToSubMenu(4); break;
					default: throw new NumberFormatException();
				}

			}
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}
}
