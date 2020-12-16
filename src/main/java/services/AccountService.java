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
		return accountDAO.saveAccount(name, user, initialAmount);
	}

	public void withdrawAmount(Account account, double amount) {
		accountDAO.addAmount(account, -amount);
	}

	public void depositAmount(Account account, double amount) {
		accountDAO.addAmount(account, amount);		
	}

	public void createTransfer(int srcAccountId, int dstAccountId, double amount) {
		accountDAO.createTransfer(srcAccountId, dstAccountId, amount);
	}
	
	public void acceptTransfer(Transfer transfer) {
		accountDAO.removeTransfer(transfer);
	}
	
	public List<Transfer> findIncomingTransfers(int dstAccountId) {
		return accountDAO.findIncomingTransfers(dstAccountId);
	}

	public Account findAccount(String username) {
		return accountDAO.findAccount(username);
	}
}
