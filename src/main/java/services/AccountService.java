package services;

import launcher.BankLauncher;
import models.Account;
import models.User;
import repositories.AccountDAO;

public class AccountService {
	AccountDAO accountDAO;
	
	public AccountService(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Account findAccount(User user) {
		return accountDAO.findAccount(user);
	}
	
	public Account createAccount(User user, double initialAmount) {
		return accountDAO.saveAccount(user, initialAmount);
	}
}
