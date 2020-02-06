import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DbConnection {

	private static final String url = "jdbc:mysql://localhost:3306/employeedatabase";
	private static final String userName = "root";
	private static final String password = "sql";
	public static DbConnection Db = new DbConnection();
	
	private DbConnection(){}
	
	public static DbConnection getInstance(){
		return Db;
	}
	static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url,
					userName, password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
}