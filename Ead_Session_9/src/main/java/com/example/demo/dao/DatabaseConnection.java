package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

// class to create database connection
public class DatabaseConnection {

	private static final String url = "jdbc:mysql://localhost:3306/employeedatabase";
	private static final String userName = "root";
	private static final String password = "sql";

	static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url,
					userName, password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(connection);
		return connection;
	}

}
