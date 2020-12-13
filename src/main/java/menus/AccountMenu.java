package menus;

public class AccountMenu extends Menu {
	public AccountMenu() {
		lines.add(() -> "1) View balance");
		lines.add(() -> "2) Withdraw");
		lines.add(() -> "3) Deposit");
		lines.add(() -> "4) Transfers");
	}
	
	@Override
	public void manageUserInput() {
		
	}

}
