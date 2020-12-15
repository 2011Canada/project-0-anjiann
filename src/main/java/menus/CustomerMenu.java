package menus;

import launcher.BankLauncher;
import services.UserService;

public class CustomerMenu extends Menu {
	UserService userService;
	
	public CustomerMenu(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void manageUserInput() {
		Account account = userService.findAccount(BankLauncher.getCurrentUser());
		if(account == null) {
			System.out.println("1) apply for account");
			BankLauncher.menuSelector.moveToSubMenu(0);
		} else {
			lines.add(() -> "1) view balance");			
			lines.add(() -> "2) withdraw");
			lines.add(() -> "3) deposit");
			lines.add(() -> "4) transfers");
			
			try {
				String input = userInput.nextLine();
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
}
