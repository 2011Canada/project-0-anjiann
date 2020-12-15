package services;

import models.Account;
import models.User;
import repositories.AccountDAO;

public class AccountService {
	AccountDAO accountDAO;
	
	public AccountService(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public Account findAccount(User currentUser) {
		
		return null;
	}
}
