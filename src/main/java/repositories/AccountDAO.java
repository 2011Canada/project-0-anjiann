package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Transfer;
import models.User;

public class AccountDAO extends DAO {
	public AccountDAO() {
		
	}
	
	public Account saveAccount(String name, User user, double balance) {
		Connection conn = cf.getConnection();
		String queryString = "insert into \"accounts\" (\"name\", \"account_id\", \"balance\") "
				+ "values (?, ?, ?) ;";
		try {
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setString(1, name);
			query.setInt(2, user.getUserId());
			query.setDouble(3, balance);
			
			query.executeUpdate();
			
			Account account = new Account(name, user.getUserId(), balance);
			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findAccount(int userId) {
		Connection conn = cf.getConnection();
		String queryString = "select * from (\"users\" u "
				+ "inner join \"accounts\" a on "
				+ "u.\"user_id\" = a.\"account_id\") "
				+ "where \"user_id\" = " + userId;
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(queryString);
			if(res.next()) {
				String name = res.getString("name");
				double balance = res.getDouble("balance");
				int accountId = res.getInt("account_id");
				
				return new Account(name, accountId, balance);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void addAmount(Account account, double amount) {
		Connection conn = cf.getConnection();
		String queryString = "update accounts set \"balance\" = "
				+ (account.getBalance() + amount) + " where \"account_id\" = " 
				+ account.getAccountId() + ";";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(queryString);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTransfer(int srcAccountId, int dstAccountId, double amount) {
		Connection conn = cf.getConnection();
		String queryString = "insert into transfers (\"src_account_id\", \"dst_account_id\", \"amount\") "
				+ "values (?, ?, ?);";
		try {
			PreparedStatement query = conn.prepareStatement(queryString);
			query.setInt(1, srcAccountId);
			query.setInt(2, dstAccountId);
			query.setDouble(3, amount);
			query.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Transfer> findIncomingTransfers(int dstAccountId) {
		Connection conn = cf.getConnection();
		String queryString = "select * from transfers where \"dst_account_id\" = "
				+ dstAccountId + ";";
		
		List<Transfer> transfers = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(queryString);
			if(res.next()) {
				transfers.add(new Transfer(res.getInt(1), res.getInt(2), res.getDouble(3)));
			}
			return transfers;
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Account findAccount(String username) {
		Connection conn = cf.getConnection();
		String queryString = "select * from (\"users\" u inner join \"accounts\" a on u.\"user_id\" = a.\"account_id\") "
				+ "where \"username\" = ?;";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			stmt.setString(1, username);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				return new Account(res.getString("name"), res.getInt("account_id"), res.getDouble("balance"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void removeTransfer(Transfer transfer) {
		Connection conn = cf.getConnection();
		String queryString = "delete from transfers where \"src_account_id\" = ? and \"dst_account_id\" = ?;";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(queryString);
			stmt.setInt(1, transfer.getSrcAccountId());
			stmt.setInt(2, transfer.getDstAccountId());
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}	
	}
}
