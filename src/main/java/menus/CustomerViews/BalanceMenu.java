package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import models.User;

public class BalanceMenu extends Menu {
	@Override
	public void manageUserInput() {
		User currentUser = BankLauncher.getCurrentUser();
		Account account = accountService.findAccount(currentUser.getUserId());
		System.out.println("your balance is $"+ account.getBalance());

		displayBackMenu();
	}

}
