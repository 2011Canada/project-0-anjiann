package services;

import repositories.AccountDAO;
import repositories.CustomerDAO;
import repositories.UserDAO;

public class ServiceProvider {
	private static ServiceProvider instance = new ServiceProvider();
	private UserService userService;
	private AccountService accountService;
	
	private ServiceProvider() {
		UserDAO userDAO = new UserDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		AccountDAO accountDAO = new AccountDAO();
		userService = new UserService(userDAO, customerDAO);
		accountService = new AccountService(accountDAO);
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}
}
