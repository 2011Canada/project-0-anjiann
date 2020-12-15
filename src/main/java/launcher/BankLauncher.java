package launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.User;
import menus.MenuSelector;

public class BankLauncher {
	private static User currentUser;
	public static MenuSelector menuSelector = new MenuSelector();
	public static Logger logger = LogManager.getLogger("com.revature.bank");


	public static void main(String[] args) {
		logger.info("server has started");
		while(true) {	
			System.out.println(menuSelector.display());
			menuSelector.handleInput();
		}
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		BankLauncher.currentUser = currentUser;
	}

}
