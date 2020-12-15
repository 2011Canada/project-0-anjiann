package menus;

import java.util.ArrayList;
import java.util.List;

import models.Displayable;
import repositories.*;
import services.UserService;

public class MenuSelector implements Displayable {

	private MenuNode rootMenu;
	private MenuNode currMenu;
	
	public MenuSelector() {		
		initializeTree(); 
	}
	
	private void initializeTree() {
		UserDAO userDAO = new UserDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		UserService userService = new UserService(userDAO, customerDAO);

		
		MainMenu mainMenu = new MainMenu();
		rootMenu = new MenuNode(mainMenu);
		currMenu = rootMenu;
		
		MenuNode loginMenuNode = new MenuNode(new LoginMenu(userService));
		MenuNode registerMenuNode = new MenuNode(new RegisterMenu(userService));
		
		rootMenu.children.add(loginMenuNode);
		rootMenu.children.add(registerMenuNode);
		loginMenuNode.parent = rootMenu;
		registerMenuNode.parent = rootMenu;
		
//		MenuNode customerMenuNode = new MenuNode()
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