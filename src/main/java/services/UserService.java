package services;

import java.util.List;

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
		
		if(user != null) BankLauncher.employeeLogger.info(user.getUsername() + " has logged in");
		return user;
	}
	
	public boolean register(String username, String password) {
		if(userDAO.findUser(username)) {
			return false;
		}
		
		customerDAO.saveCustomer(username, password);
		BankLauncher.employeeLogger.info("registered a new user with username " + username);

		return true;
	}
	
	public String findUsername(int userId) {
		return userDAO.findUsername(userId);
	}
	
	public List<User> findUsers() {
		return customerDAO.findCustomers();
	}
}
