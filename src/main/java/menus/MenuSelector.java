package menus;

import java.util.ArrayList;
import java.util.List;

import models.Displayable;

public class MenuSelector implements Displayable {

	private MenuNode rootMenu;
	private MenuNode currMenu;
	
	public MenuSelector() {		
		initializeTree(); 
	}
	
	private void initializeTree() {
		MainMenu mainMenu = new MainMenu();
		rootMenu = new MenuNode(mainMenu);
		currMenu = rootMenu;
		
		MenuNode loginMenuNode = new MenuNode(new LoginMenu());
		MenuNode registerMenuNode = new MenuNode(new RegisterMenu());
		
		rootMenu.children.add(loginMenuNode);
		rootMenu.children.add(registerMenuNode);
	}
	
	
	static class MenuNode {	
		public Menu val;
		
		public MenuNode parent;
		
		public List<MenuNode> children = new ArrayList<>();
		
		
		public MenuNode(Menu menu)  {
			this.val = menu;
		}
	}

	public String display() {
		return currMenu.val.display();
	}
	
	
	public void handleInput() {
		currMenu.val.manageUserInput();
	}
	
	public void moveToSubMenu(int index) {
		this.currMenu = currMenu.children.get(index);
	}
	
	public void returnToPrevious() {
		this.currMenu = currMenu.parent;
	}
}