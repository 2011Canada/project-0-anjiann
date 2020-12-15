package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Account;
import util.ConnectionFactory;

public class AccountDAO extends DAO {
	public AccountDAO() {
		
	}
	
	public Account saveAccount(int account_id, double balance) {
		Connection conn = cf.getConnection();
		String queryString = "insert into \"accounts\" (\"account_id\", \"balance\") "
				+ "values (?, ?) ;";
		try {
			PreparedStatement query = conn.prepareStatement(queryString);
			
			query.executeUpdate(queryString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findAccount(int accountId) {
		
		return null;
	}
}
