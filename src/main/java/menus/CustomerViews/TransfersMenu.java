package menus.CustomerViews;

import launcher.BankLauncher;
import menus.Menu;

public class TransfersMenu extends Menu {
	public TransfersMenu() {
		lines.add(() -> "1) Post a transfer");
		lines.add(() -> "2) Accept a transfer");
		lines.add(() -> "3) back");
	}

	@Override
	public void manageUserInput() {
		String input = userInput.nextLine();
		try {
			int choice = Integer.parseInt(input) - 1;

			switch(choice) {
				case 0: BankLauncher.menuSelector.moveToSubMenu(0); break;
				case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
				case 2: BankLauncher.menuSelector.returnToPrevious(); break;
				default: throw new NumberFormatException();
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}

}
