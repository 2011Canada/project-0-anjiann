package services;

import exceptions.*;
import launcher.BankLauncher;
import models.*;
import repositories.CustomerDAO;
import repositories.UserDAO;

public class UserService {	
	private UserDAO userDAO;
	private CustomerDAO customerDAO;
	
	public UserService(UserDAO userDAO, CustomerDAO customerDAO) {
		this.userDAO = userDAO;
		this.customerDAO = customerDAO;
	}
	
	public User login(String username, String password) {
		User user = userDAO.findUserByCredentials(username, password);
		BankLauncher.setCurrentUser(user);
		
		BankLauncher.logger.debug(user + "has logged in");
		return user;
	}
	
	public boolean register(String username, String password) {
		if(userDAO.findUser(username)) {
			return false;
		}
		
		customerDAO.saveCustomer(username, password);
		
		return true;
	}
}
