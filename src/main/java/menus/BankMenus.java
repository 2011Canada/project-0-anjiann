package menus;

import menus.MenuSelector.MenuNode;
import services.AccountService;
import services.ServiceProvider;
import services.UserService;

public class BankMenus {
	private static BankMenus instance = new BankMenus();
	
	private MainMenu mainMenu;
	private LoginMenu loginMenu;
	private RegisterMenu registerMenu;
	private CustomerMenu customerMenu;
	
	private BankMenus() {
		UserService userService = ServiceProvider.getInstance().getUserService();
		AccountService accountService = ServiceProvider.getInstance().getAccountService();

		
		mainMenu = new MainMenu();
		loginMenu = new LoginMenu(userService);
		registerMenu = new RegisterMenu(userService);
		customerMenu = new CustomerMenu(userService, accountService);
	}
	
	public static BankMenus getInstance() {
		return instance;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public LoginMenu getLoginMenu() {
		return loginMenu;
	}

	public RegisterMenu getRegisterMenu() {
		return registerMenu;
	}

	public CustomerMenu getCustomerMenu() {
		return customerMenu;
	}
}
