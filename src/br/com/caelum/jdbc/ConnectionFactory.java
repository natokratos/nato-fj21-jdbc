package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
		public Connection getConnection() throws ClassNotFoundException {
			try {
				String dbName = System.getProperty("RDS_DB_NAME");
				String userName = System.getProperty("RDS_USERNAME");
				String password = System.getProperty("RDS_PASSWORD");
				String hostname = System.getProperty("RDS_HOSTNAME");
				String port = System.getProperty("RDS_PORT");
				
				Class.forName("com.mysql.jdbc.Driver");
				if(dbName == null || dbName.isEmpty()) {
					return DriverManager.getConnection("jdbc:mysql://dbfj21.ci0ikiylvrtz.us-west-2.rds.amazonaws.com:3306/dbfj21", "natoadmin", "paTTynaTTo1102");
				} else {
					return DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + dbName, userName, password);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}