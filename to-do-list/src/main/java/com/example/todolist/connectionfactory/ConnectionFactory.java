package com.example.todolist.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnectionBd() throws SQLException {
		try {
			Connection connection = null;

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/to_do_list";

			String username = "root";
			String password = "@Nvoip2020#";

			connection = DriverManager.getConnection(url, username, password);

			return connection;

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}
	
	
