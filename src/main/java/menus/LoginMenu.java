package menus;

import launcher.BankLauncher;
import services.UserService;

public class LoginMenu extends Menu {
	private UserService userService;

	public LoginMenu() {
		lines.add(() -> "enter your username:");
		lines.add(() -> "enter your password:");
	}
	
	@Override
	public void manageUserInput() {
		this.userInput.nextLine();
		System.out.println("Please Enter your Username");
		String username = this.userInput.nextLine();
		System.out.println("Please Enter your Password");
		String password = this.userInput.nextLine();
		
//		System.out.println(this.userService.login(username, password).display());
//		if(BankLauncher.getCurrentUser() != null) {
			BankLauncher.menuSelector.moveToSubMenu(0);
//		}
	}

}
