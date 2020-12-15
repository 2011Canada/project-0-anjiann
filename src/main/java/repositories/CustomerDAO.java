package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Customer;

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
}
