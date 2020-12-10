package launcher;

import java.util.Scanner;
import menus.BankMenu;

public class BankLauncher {
	public static void main(String[] args) {
		BankMenu bankMenu = new BankMenu();
		System.out.println("Hello. Welcome to the Revature bank.");
		bankMenu.getUserType();
	}

}
