package menus.CustomerViews;

import java.util.List;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import models.Transfer;

public class AcceptTransferMenu extends Menu {

	@Override
	public void manageUserInput() {
		int currUserId = BankLauncher.getCurrentUser().getUserId();
		Account currAccount = accountService.findAccount(currUserId);
		List<Transfer> srcAccounts = accountService.findIncomingTransfers(currUserId);
		if(srcAccounts == null || srcAccounts.size() == 0) {
			System.out.println("you do not have any incoming transfers.");
			displayBackMenu();
			return;
		}
		System.out.println("please enter in the option number of the transfer you would like to accept:");
		for(int i = 0; i < srcAccounts.size(); i++) {
			Transfer transfer = srcAccounts.get(i);
			String username = userService.findUsername(transfer.getSrcAccountId());
			System.out.println((i + 1) + ") " + username + " sent you " + transfer.getAmount());
		}
		
		try {
			String input = userInput.nextLine();
			int index = Integer.parseInt(input) - 1;
			Transfer transfer = srcAccounts.get(index);
			
			accountService.acceptTransfer(transfer);
			accountService.depositAmount(currAccount, transfer.getAmount());
			
			currAccount = accountService.findAccount(currUserId);
			System.out.println("successfully deposited. your new balance is: $" + currAccount.getBalance());
		} catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}

}
