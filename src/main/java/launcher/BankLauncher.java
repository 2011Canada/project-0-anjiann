package launcher;

import java.util.Scanner;

import models.User;

import menus.BankMenu;
import menus.MenuOptions.UserType;
import menus.MenuSelector;

public class BankLauncher {
	private static User currentUser;
	public static MenuSelector menuSelector = new MenuSelector();

	public static void main(String[] args) {
		BankMenu bankMenu = new BankMenu();
		bankMenu.welcome();
		UserType userType = bankMenu.getUserType();
	}

	public static User getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(User currentUser) {
		BankLauncher.currentUser = currentUser;
	}

}
