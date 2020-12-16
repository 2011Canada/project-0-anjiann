package menus;

import launcher.BankLauncher;
import models.*;
import services.UserService;

public class LoginMenu extends Menu {
	@Override
	public void manageUserInput() {
		System.out.println("Please Enter your Username");
		String username = this.userInput.nextLine();
		System.out.println("Please Enter your Password");
		String password = this.userInput.nextLine();
		
		User user = this.userService.login(username, password);
		if(user == null) {
			System.out.println("Incorrect username or password. Try again");
		}
		else {
			System.out.println("welcome " + user.display());
			if(user instanceof Customer) {
				BankLauncher.menuSelector.moveToSubMenu(0);
			} else if(user instanceof Employee) {
				BankLauncher.menuSelector.moveToSubMenu(1);
			}
		}
	}

}
