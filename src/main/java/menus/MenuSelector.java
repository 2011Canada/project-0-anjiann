package menus;

import java.util.ArrayList;
import java.util.List;

import models.Displayable;
import repositories.*;
import services.*;

public class MenuSelector implements Displayable {

	private MenuNode rootMenu;
	private MenuNode currMenu;
	
	public MenuSelector() {		
		initializeTree(); 
	}
	
	private void initializeTree() {
		BankMenus bankMenus = BankMenus.getInstance();
		
		rootMenu = new MenuNode(bankMenus.getMainMenu());
		currMenu = rootMenu;
		
		MenuNode loginMenuNode = new MenuNode(bankMenus.getLoginMenu());
		MenuNode registerMenuNode = new MenuNode(bankMenus.getRegisterMenu());
		MenuNode customerMenuNode = new MenuNode(bankMenus.getCustomerMenu());

		rootMenu.children.add(loginMenuNode);
		rootMenu.children.add(registerMenuNode);
		loginMenuNode.parent = rootMenu;
		registerMenuNode.parent = rootMenu;
		
		loginMenuNode.children.add(customerMenuNode);
		
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