package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;

public class DepositMenu extends Menu {

	@Override
	public void manageUserInput() {
		Account account = accountService.findAccount(BankLauncher.getCurrentUser().getUserId());
		System.out.println("how much would you like to deposit?");
		System.out.print("$");

		String input = userInput.nextLine();
		try {
			double amount = Double.parseDouble(input);
			if(amount <= 0) {
				throw new NumberFormatException();
			}
			
			accountService.depositAmount(account, amount);
			account = accountService.findAccount(BankLauncher.getCurrentUser().getUserId());
			System.out.println("your new balance is: " + account.getBalance());
		} catch(NumberFormatException e) {
			System.out.println("Invalid dollar amount. Try again");
		}
		
		displayBackMenu();
	}

}
