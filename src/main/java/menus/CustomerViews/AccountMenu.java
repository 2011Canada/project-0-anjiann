package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;

public class AccountMenu extends Menu {
	@Override
	public void manageUserInput() {	
		int userId = BankLauncher.getCurrentUser().getUserId();
		Account account = accountService.findAccount(userId);
		if(account.getStatus() == 0) {
			System.out.println("your account application is pending approval. Now exiting application");
			System.exit(0);
		} else if(account.getStatus() == 2) {
			System.out.println("your account application is rejected. Contact customer support for details");
			System.exit(0);
		}
		
		System.out.println("1) View balance");
		System.out.println("2) Withdraw");
		System.out.println("3) Deposit");
		System.out.println("4) Transfers");
		try {
			String input = userInput.nextLine();
			int index = Integer.parseInt(input) - 1;
			BankLauncher.menuSelector.moveToSubMenu(index);
		} catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}

}
