package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;

public class WithdrawMenu extends Menu {

	@Override
	public void manageUserInput() {
		Account account = accountService.findAccount(BankLauncher.getCurrentUser().getUserId());
		System.out.println("your current balance: " + account.getBalance());
		System.out.println("how much would you like to withdraw?");
		System.out.print("$");
		String input = userInput.nextLine();
		try {
			double amount = Double.parseDouble(input);
			if(amount < 0 || amount > account.getBalance()) {
				throw new NumberFormatException();
			}
			
			accountService.withdrawAmount(account, amount);
			account = accountService.findAccount(BankLauncher.getCurrentUser().getUserId());
			System.out.println("your new balance is: " + account.getBalance());
		} catch(NumberFormatException e) {
			System.out.println("Invalid amount. Try again");
			return;
		}
		
		displayBackMenu();
	}
}
