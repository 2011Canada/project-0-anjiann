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

public class UserDAO {
	protected ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
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
	
	private void setUserFields(User u, ResultSet res) throws SQLException {
		u.setUserId(res.getInt("user_id"));
		u.setUsername(res.getString("username"));
		u.setPassword(res.getString("password"));
	}
	
	public User findUserByCredentials(String username, String password) {
		try {
			Connection conn = cf.getConnection();

			String queryString = "select * from \"users\" where \"username\" = ? and \"password\" = ? ;";
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
	
	
	public List<User> findUsers() {
		String queryString = "select * from users where \"username\" = \'BS\'";
		Connection conn = cf.getConnection();
		try {
//			Statement stmt = conn.createStatement();
//			ResultSet res = stmt.executeQuery(queryString);
			queryString = "select * from \"users\" where \"username\" = ? ;";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, "BS");
			
			ResultSet res = query.executeQuery();
			if(res.next()) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
