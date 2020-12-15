package menus.CustomerViews;

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
		System.out.println("Please enter the option number: ");
		String input = userInput.nextLine();
		
	}

}
