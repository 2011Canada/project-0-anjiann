package services;

import models.User;

public class AccountService {
	private static final AccountService instance = new AccountService();
	
	private AccountService() {
		
	}
	
	public AccountService getInstance() {
		return instance;
	}
}
