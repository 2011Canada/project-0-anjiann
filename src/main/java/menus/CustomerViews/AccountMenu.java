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
			int choice = Integer.parseInt(input) - 1;
			switch(choice) {
				case 0: BankLauncher.menuSelector.moveToSubMenu(0); break;
				case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
				case 2: BankLauncher.menuSelector.moveToSubMenu(2); break;
				case 3: BankLauncher.menuSelector.moveToSubMenu(3); break;
				default: throw new NumberFormatException();
			}
		} catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}

}
