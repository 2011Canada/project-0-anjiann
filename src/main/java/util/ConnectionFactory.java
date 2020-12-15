package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private Connection [] conn;
	
	private static ConnectionFactory cf = new ConnectionFactory(1);

	private ConnectionFactory(int numberOfConnections) {
		
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");
		try {
			this.conn = new Connection[numberOfConnections];
			for(int i = 0; i< this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				this.conn[i] = conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	
	//todo for multiple connections
	public Connection getConnection() {
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
	}
}
