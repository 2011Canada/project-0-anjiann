package menus.EmployeeViews;

import launcher.BankLauncher;
import menus.Menu;

public class EmployeeMenu extends Menu {
	public EmployeeMenu() {
		lines.add(() -> "1) approve or reject accounts");
		lines.add(() -> "2) view customer's account");
		lines.add(() -> "3) view transaction logs");
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
