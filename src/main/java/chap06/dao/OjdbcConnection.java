package chap06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OjdbcConnection {
	private String jdbcUrl;
	private String user;
	private String pwd;
	
	public OjdbcConnection(String jdbcUrl, String user, String pwd) {
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.pwd = pwd;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, user, pwd);
	}
}
