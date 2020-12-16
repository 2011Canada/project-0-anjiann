package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;
import models.Account;
import models.User;
import services.ServiceProvider;

public class BalanceMenu extends Menu {
	@Override
	public void manageUserInput() {
		// TODO Auto-generated method stub
		System.out.print("your balance is ");
		User currentUser = BankLauncher.getCurrentUser();
		Account account = ServiceProvider.getInstance().getAccountService().findAccount(currentUser);
		
		System.out.println(account.getBalance());
	}

}
