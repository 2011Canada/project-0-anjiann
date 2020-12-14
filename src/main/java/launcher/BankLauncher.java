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
