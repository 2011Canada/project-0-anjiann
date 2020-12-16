package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;

public class PostTransferMenu extends Menu {

	@Override
	public void manageUserInput() {
		System.out.println("enter the username of the person you want to transfer to:");
		String input = userInput.nextLine();
		Account dstAccount = accountService.findAccount(input);
		if(dstAccount == null) {
			System.out.println("cannot find a user with that username. Try again.");
			return;
		}
		int currUserId = BankLauncher.getCurrentUser().getUserId();
		if(dstAccount.getAccountId() == currUserId) {
			System.out.println("you cannot transfer money to yourself.");
			return;
		}
		
		Account srcAccount = accountService.findAccount(currUserId);
		System.out.println("your current balance: " + srcAccount.getBalance());
		System.out.println("enter in the amount you would like to transfer:");
		System.out.print("$");
		
		input = userInput.nextLine();
		try {
			double amount = Double.parseDouble(input);
			if(amount <= 0 || amount > srcAccount.getBalance()) {
				throw new NumberFormatException();
			}
			
			accountService.withdrawAmount(srcAccount, amount);
			accountService.createTransfer(srcAccount.getAccountId(), dstAccount.getAccountId(), amount);
			srcAccount = accountService.findAccount(currUserId);
			System.out.println("your new balance is: $" + srcAccount.getBalance());
		} catch(NumberFormatException e) {
			System.out.println("Invalid dollar amount. Try again");
		}
		
		displayBackMenu();
	}

}
