package repositories;

import java.sql.SQLException;

public class BankDAODebugger {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
//		userDAO.findUsers();
		
		CustomerDAO customerDAO = new CustomerDAO();
		try {
			customerDAO.saveUser("bill", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
