package menus;

public class RegisterMenu extends Menu {

	@Override
	public void manageUserInput() {
		System.out.println("Please Enter your Username");
		String username = this.userInput.nextLine();
		System.out.println("Please Enter your Password");
		String password = this.userInput.nextLine();
	}

}
