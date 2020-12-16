package services;

import java.util.List;

import launcher.BankLauncher;
import models.Account;
import models.Transfer;
import models.User;
import repositories.AccountDAO;

public class AccountService {
	AccountDAO accountDAO;
	
	public AccountService(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Account findAccount(int userId) {
		return accountDAO.findAccount(userId);
	}
	
	public Account createAccount(String name, User user, double initialAmount) {
		BankLauncher.employeeLogger.info("user " + user.getUsername() + " has created a new " 
					+ name + " account with an initial amount of " + initialAmount);
		
		return accountDAO.saveAccount(name, user, initialAmount);
	}

	public void withdrawAmount(Account account, double amount) {
		accountDAO.addAmount(account, -amount);

		String username = BankLauncher.getCurrentUser().getUsername();
		BankLauncher.employeeLogger.info("user " + username + " has withdrawn $" + amount);
	}

	public void depositAmount(Account account, double amount) {
		accountDAO.addAmount(account, amount);		

		String username = BankLauncher.getCurrentUser().getUsername();
		BankLauncher.employeeLogger.info("user " + username + " has deposited $" + amount);
	}

	public void createTransfer(int srcAccountId, int dstAccountId, double amount) {
		accountDAO.createTransfer(srcAccountId, dstAccountId, amount);
		
		String srcUsername = BankLauncher.getCurrentUser().getUsername();
		String dstUsername = ServiceProvider.getInstance().getUserService().findUsername(dstAccountId);
		BankLauncher.employeeLogger.info("user " + srcUsername + " has transferred $" + amount + " to user" + dstUsername);
	}
	
	public void acceptTransfer(Transfer transfer) {		
		accountDAO.removeTransfer(transfer);
		
		UserService userService = ServiceProvider.getInstance().getUserService();
		String srcUsername = userService.findUsername(transfer.getSrcAccountId());
		String dstUsername = userService.findUsername(transfer.getDstAccountId());
		BankLauncher.employeeLogger.info("user " + dstUsername + " has accepted $" + transfer.getAmount()
				+ " from user" + srcUsername);
	}
	
	public List<Transfer> findIncomingTransfers(int dstAccountId) {
		return accountDAO.findIncomingTransfers(dstAccountId);
	}

	public Account findAccount(String username) {
		return accountDAO.findAccount(username);
	}

	public List<Account> findAccounts() {
		return accountDAO.findAccounts();
	}
	

	public List<Account> findPendingAccounts(int accountStatus) {
		return accountDAO.findPendingAccounts();
	}

	public void updateAccountStatus(Account account, int accountStatus) {
		accountDAO.updateAccountStatus(account.getAccountId(), accountStatus);

		User employee = BankLauncher.getCurrentUser();
		String user = ServiceProvider.getInstance().getUserService().findUsername(account.getAccountId());
		String status = accountStatus == 0 ? "pending" : 
			(accountStatus == 1 ? "approved" : "rejected");
		BankLauncher.employeeLogger.info("employee " + employee.getUsername() 
				+ " has " + status + " " + user + "'s " + account.getName() + " account");
	}
}
