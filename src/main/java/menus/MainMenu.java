package menus;

import launcher.BankLauncher;

public class MainMenu extends Menu {
	public MainMenu() {
		lines.add(() -> "Enter the option number:");
		lines.add(() -> "1) Customer");
		lines.add(() -> "2) Employee");
	}

	@Override
	public void manageUserInput() {
		String input = userInput.nextLine();
		int choice = Integer.parseInt(input) - 1;
		switch(choice) {
			case 0: BankLauncher.menuSelector.moveToSubMenu(0); break;
			case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
			default: System.out.println("Not a valid choice"); break;
		}
	}
}
