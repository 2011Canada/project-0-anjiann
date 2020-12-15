package menus;

import launcher.BankLauncher;

public class MainMenu extends Menu {
	public MainMenu() {
		lines.add(() -> "1) Login");
		lines.add(() -> "2) Register");
	}

	@Override
	public void manageUserInput() {
		System.out.println("Please enter the option number:");
		String input = userInput.nextLine();
		try {
			int choice = Integer.parseInt(input) - 1;
			switch(choice) {
				case 0: BankLauncher.menuSelector.moveToSubMenu(0); break;
				case 1: BankLauncher.menuSelector.moveToSubMenu(1); break;
				default: System.out.println("Not a valid choice. Please enter the option number"); break;
			}
		} catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}
}
