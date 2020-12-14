package services;

import exceptions.*;
import launcher.BankLauncher;
import models.*;
import repositories.UserDAO;

public class UserService {	
	private UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public Displayable login(String username, String password) {
		try {
			User user = userDAO.findUser(username, password);
			BankLauncher.setCurrentUser(user);
			return () -> "welcome" + user;
		} catch (UserNotFoundException | InternalErrorException e) {
			return ()->e.getMessage();
		}
	}
}
