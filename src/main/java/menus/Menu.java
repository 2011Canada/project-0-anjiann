package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
		String display = "\n";
		for(Displayable line : lines) {
			display += line.display() + "\n"; 
		}
		
		return display;
	}
	
	public abstract void manageUserInput();
}
