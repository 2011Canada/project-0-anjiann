package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Employee;
import models.User;

public class EmployeeDAO extends UserDAO {
	public User findEmployee(String username, String password) {
		try {
			Connection conn = cf.getConnection();

			String queryString = "(select * from (\"users\" u inner join where \"username\" = ? and \"password\" = ?) u"
					+ "inner join"
					+ "\"employees\" e"
					+ "on u.\"user_id\" = a.\"employee_id\";";
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, username);
			query.setString(2, password);
			
			ResultSet res = query.executeQuery();

			if(res.next()) {
				User user = new Employee();
				
				setUserFields(user, res);
				
				return user;
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
