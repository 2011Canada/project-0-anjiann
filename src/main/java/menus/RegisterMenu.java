package menus;

import launcher.BankLauncher;
import services.*;
public class RegisterMenu extends Menu {
	private UserService userService;

	public RegisterMenu(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public void manageUserInput() {
		System.out.println("Please Enter your Username:");
		String username = this.userInput.nextLine();
//		if(userService.existsUser(username)) {
//			System.out.println("this username is taken");
//			return;
//		}
		
		System.out.println("Please enter your password:");
		String password = this.userInput.nextLine();
		
		boolean success = userService.register(username, password);
		if(success) {
			System.out.println("Successfully registered");
			BankLauncher.menuSelector.returnToPrevious();
		} else {
			System.out.println("failed to register. Try again");
		}
	}

}
