package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Customer;
import models.User;

public class CustomerDAO extends UserDAO {
	public Customer saveCustomer(String username, String password) {
		try {
			ResultSet queryRes = saveUser(username, password);
			
			int userId;
			if (queryRes.next()) {
				userId = queryRes.getInt("user_id");
			} else {
				throw new SQLException();
			}
			
			String queryString = "insert into \"customers\" (\"customer_id\")"
					+ "values (" + userId + ")";
			Connection conn = cf.getConnection();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
			
			Customer customer = new Customer(userId, username, password);
			
			return customer;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User findCustomer(String username, String password) {
		try {
			Connection conn = cf.getConnection();

			String queryString = "(select * from (\"users\" u inner join where \"username\" = ? and \"password\" = ?) u"
					+ "inner join"
					+ "\"customers\" a"
					+ "on u.\"user_id\" = a.\"customer_id\";";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, username);
			query.setString(2, password);
			
			ResultSet res = query.executeQuery();

			if(res.next()) {
				User user = new Customer();
				
				setUserFields(user, res);
				
				return user;
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<User> findCustomers() {
		Connection conn = cf.getConnection();
		String queryString = "select * from (\"users\" u inner join \"customers\" c on u.\"user_id\" = c.\"customer_id\");";
		
		List<User> customers = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(queryString);
			if(res.next()) {
				String name = res.getString("username");
				String password = res.getString("password");
				int accountId = res.getInt("customer_id");
				
				customers.add(new Customer(accountId, name, password));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return customers;
	}
}
