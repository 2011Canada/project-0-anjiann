package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import launcher.BankLauncher;
import models.Displayable;
import services.AccountService;
import services.ServiceProvider;
import services.UserService;

public abstract class Menu implements Displayable{
	protected List<Displayable> lines = new ArrayList<>();
	protected Scanner userInput = new Scanner(System.in);
	protected AccountService accountService = ServiceProvider.getInstance().getAccountService();
	protected UserService userService = ServiceProvider.getInstance().getUserService();
	
	public String display() {
		String display = "\n================\n";
		for(Displayable line : lines) {
			display += line.display() + "\n"; 
		}
		
		return display;
	}
	
	protected void displayBackMenu() {
		System.out.println("1) back ");
		System.out.println("2) exit ");
		
		String input = userInput.nextLine();
		try {
			int choice = Integer.parseInt(input);

			switch(choice) {
				case 1: BankLauncher.menuSelector.returnToPrevious(); break;
				case 2: System.exit(0);
				default: throw new NumberFormatException();
			}
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid choice. Please enter the option number");
		}
	}
	
	public abstract void manageUserInput();
}
