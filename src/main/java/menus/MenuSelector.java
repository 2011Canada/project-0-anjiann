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
		MenuNode applicationMenuNode = new MenuNode(bankMenus.getApplicationMenu());
		MenuNode accountMenuNode = new MenuNode(bankMenus.getAccountMenu());
		MenuNode balanceMenuNode = new MenuNode(bankMenus.getBalanceMenu());
		MenuNode withdrawMenuNode = new MenuNode(bankMenus.getWithdrawMenu());
		MenuNode depositMenuNode = new MenuNode(bankMenus.getDepositMenu());
		MenuNode transfersMenuNode = new MenuNode(bankMenus.getTransfersMenu());
		MenuNode postTransferMenuNode = new MenuNode(bankMenus.getPostTransferMenu());
		MenuNode acceptTransferMenuNode = new MenuNode(bankMenus.getAcceptTransferMenu());
		
		MenuNode employeeMenuNode = new MenuNode(bankMenus.getEmployeeMenu());
		MenuNode transactionsMenuNode = new MenuNode(bankMenus.getTransactionsMenu());
		MenuNode accountApprovalMenuNode = new MenuNode(bankMenus.getAccountApprovalMenu());

		linkMenuNodes(rootMenu, loginMenuNode);
		linkMenuNodes(rootMenu, registerMenuNode);
		
		linkMenuNodes(loginMenuNode, customerMenuNode);
		linkMenuNodes(loginMenuNode, employeeMenuNode);
		
		//== customer views subtree ==
		linkMenuNodes(customerMenuNode, applicationMenuNode);
		linkMenuNodes(customerMenuNode, accountMenuNode);
		
		linkMenuNodes(accountMenuNode, balanceMenuNode);
		linkMenuNodes(accountMenuNode, withdrawMenuNode);
		linkMenuNodes(accountMenuNode, depositMenuNode);
		linkMenuNodes(accountMenuNode, transfersMenuNode);
		
		linkMenuNodes(transfersMenuNode, postTransferMenuNode);
		linkMenuNodes(transfersMenuNode, acceptTransferMenuNode);
		
		//== employee views subtree ==
		linkMenuNodes(employeeMenuNode, transactionsMenuNode);
		linkMenuNodes(employeeMenuNode, accountApprovalMenuNode);
	}
	
	private void linkMenuNodes(MenuNode parent, MenuNode child) {
		parent.children.add(child);
		child.parent = parent;
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