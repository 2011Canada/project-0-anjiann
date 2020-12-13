package menus;

public class MenuOptions {
	public static enum UserType { Customer, Employee };
	public static enum CustomerAction { ApplyAccount, ViewBalance, Withdraw, Deposit, Transfer, AcceptTransfer, PostTransfer };
	public static enum EmployeeAction { ApproveAccount, RejectAccount, ViewAccount, ViewTransactions };
}
