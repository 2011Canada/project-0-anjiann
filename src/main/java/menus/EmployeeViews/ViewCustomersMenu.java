package menus.EmployeeViews;

import java.util.List;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import models.User;

public class ViewCustomersMenu extends Menu {

	@Override
	public void manageUserInput() {
		List<Account> accounts = accountService.findAccounts();
		BankLauncher.logger.debug("number of accounts: " + accounts.size());
		for(int i = 0; i < accounts.size(); i++) {
			Account account = accounts.get(i);
			String username = userService.findUsername(account.getAccountId());
			String status = "pending";
			switch(account.getStatus()) {
				case 0: status = "pending"; break;
				case 1: status = "accepted"; break;
				case 2: status = "rejected"; break;
			}
			System.out.println("user: " + username + ", account type: " 
					+ account.getName() + ", balance: " + account.getBalance()
					+ ", status: " + status);
		}
		
		displayBackMenu();
	}

}
