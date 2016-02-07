

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * STEP1: Register Driver by using class.forName("mention driver name to be registered")
 * STEP2: Connecting to DB by using Connection object
 */

public class ConnectionEstablishment {
	public static Connection createConnection() {
		// JDBC driver name and database URL
		// to register driver, driver name is used
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// DB to which we need to connect, nuggu is database name
		final String DB_URL = "jdbc:mysql://localhost:3306/nuggu";
		// Database credentials
		final String USER = "root";
		final String PASS = "abc@123";
		// STEP 1: Register JDBC driver
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// STEP 2: Open a connection
		System.out.println("Connecting to database...");
		try {
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connected!");
			return conn;
		} catch (SQLException e) {
			System.out.println("connection failed");
			return null;
		}

	}
}