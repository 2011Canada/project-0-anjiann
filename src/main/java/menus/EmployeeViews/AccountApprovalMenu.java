package menus.EmployeeViews;

import java.util.List;

import menus.Menu;
import models.Account;

public class AccountApprovalMenu extends Menu {

	@Override
	public void manageUserInput() {
		List<Account> pendingAccounts = accountService.findAccounts();
		for(int i = 0; i < pendingAccounts.size(); i++) {
			Account account = pendingAccounts.get(i);
			String username = userService.findUsername(account.getAccountId());
			System.out.println((i + 1) + " ) user: " + username + ", account type: " 
					+ account.getName() + ", balance: " + account.getBalance());
		}
		
		try {
			String input = userInput.nextLine();
			int index = Integer.parseInt(input) - 1;
			Account selectedAccount = pendingAccounts.get(index);
			System.out.println("1) accept account");
			System.out.println("2) reject account");
			input = userInput.nextLine();
			int choice = Integer.parseInt(input);
			int accountStatus = 0;
			switch(choice) {
				case 1: accountStatus = 1; break;
				case 2: accountStatus = 2; break;
				default: throw new NumberFormatException();
			}
			accountService.updateAccountStatus(selectedAccount.getAccountId(), accountStatus);
		} catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
		
		displayBackMenu();
	}

}
