package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.postgresql.util.PSQLException;

import exceptions.InternalErrorException;
import exceptions.UserNotFoundException;
import launcher.BankLauncher;
import models.Customer;
import models.Employee;
import models.User;
import util.ConnectionFactory;

public class UserDAO extends DAO {	
	protected ResultSet saveUser(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();

		String queryString = "insert into \"users\" "
				+ "(\"username\", \"password\") "
				+ "values (?, ?) "
				+ "returning \"user_id\" ;";
		
		PreparedStatement query = conn.prepareStatement(queryString);
		query.setString(1, username);
		query.setString(2, password);

		
		ResultSet res = query.executeQuery();

		return res;
	}
	
	protected void setUserFields(User u, ResultSet res) throws SQLException {
		u.setUserId(res.getInt("user_id"));
		u.setUsername(res.getString("username"));
		u.setPassword(res.getString("password"));
	}
	
	//TODO refactor zzz
	private User findUserByCredentials(String userType, String username, String password) {
		try {
			Connection conn = cf.getConnection();
			String userTypeId = (userType == "customers") ? "customer_id" : "employee_id";
			String queryString = "select * from (\"users\" u inner join \"" + userType + "\" c "
					+ "on u.\"user_id\" = c.\"" + userTypeId + "\") "
					+ "where \"username\" = ? and \"password\" = ?;";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, username);
			query.setString(2, password);
			
			ResultSet res = query.executeQuery();

			if(res.next()) {
				User user = (userType == "customers") ? new Customer() : new Employee();
				
				setUserFields(user, res);
				
				return user;
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public User findUserByCredentials(String username, String password) {
		User customer = findUserByCredentials("customers", username, password);
		User employee = findUserByCredentials("employees", username, password);

		return customer == null ? employee : customer;
	}
	
	public String findUsername(int userId) {
		try {
			Connection conn = cf.getConnection();

			String queryString = "select * from \"users\" where \"user_id\" = ? ;";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setInt(1, userId);
			
			ResultSet res = query.executeQuery();

			if(res.next()) {				
				return res.getString("username");
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean findUser(String username) {
		try {
			Connection conn = cf.getConnection();

			String queryString = "select * from \"users\" where \"username\" = ? ;";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, username);
			
			ResultSet res = query.executeQuery();

			if(res.next()) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		
		return false;
	}

}
