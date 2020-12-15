package menus;

import launcher.BankLauncher;
import models.Account;
import services.AccountService;
import services.UserService;

public class CustomerMenu extends Menu {
	UserService userService;
	AccountService accountService;
	
	public CustomerMenu(UserService userService, AccountService accountService) {
		this.userService = userService;
		this.accountService = accountService;
	}
	
	@Override
	public void manageUserInput() {
		Account account = accountService.findAccount(BankLauncher.getCurrentUser());
		if(account == null) {
			System.out.println("1) apply for account");
			BankLauncher.menuSelector.moveToSubMenu(0);
		} else {
			lines.add(() -> "1) view balance");			
			lines.add(() -> "2) withdraw");
			lines.add(() -> "3) deposit");
			lines.add(() -> "4) transfers");
			
			try {
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input) - 1;
				switch(choice) {
					case 0: BankLauncher.menuSelector.moveToSubMenu(0); break;
					case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
					default: System.out.println("Not a valid choice. Please enter the option number"); break;
				}
			} catch(NumberFormatException e) {
				System.out.println("Not a valid choice. Please enter the option number");
			}
		}
	}
}
