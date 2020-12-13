package menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Displayable;

public abstract class Menu implements Displayable{
	protected List<Displayable> lines = new ArrayList<>();
	protected Scanner userInput = new Scanner(System.in);
	
	public String display() {
		String display = "";
		for(Displayable line : lines) {
			display += line.display() + "\n"; 
		}
		
		return display;
	}
	
	public abstract void manageUserInput();
}
