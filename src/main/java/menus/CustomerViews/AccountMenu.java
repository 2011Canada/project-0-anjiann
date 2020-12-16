package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;

public class AccountMenu extends Menu {
	public AccountMenu() {
		lines.add(() -> "1) View balance");
		lines.add(() -> "2) Withdraw");
		lines.add(() -> "3) Deposit");
		lines.add(() -> "4) Transfers");
	}
	
	@Override
	public void manageUserInput() {	
		try {
			String input = userInput.nextLine();
			int index = Integer.parseInt(input) - 1;
			BankLauncher.menuSelector.moveToSubMenu(index);
		} catch(NumberFormatException | IndexOutOfBoundsException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}

}
