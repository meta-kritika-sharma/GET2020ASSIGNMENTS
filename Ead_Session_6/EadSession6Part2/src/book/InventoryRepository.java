package book;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InventoryRepository {

	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/book";
	private final String DB_user = "root";
	private final String DB_PASSWORD = "sql";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	ArrayList<String> list = new ArrayList<String>();
	private static InventoryRepository object = new InventoryRepository();

	private InventoryRepository() {
	}

	/* Method to create database connection */
	
	public void connection() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = (Connection) DriverManager.getConnection(DB_URL,
					DB_user, DB_PASSWORD);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	public static InventoryRepository getInstance() {
		return object;
	}

	/*
	 * Method to insert data into the database
	 * @param inventory object
	 */
	public void setDataEmployee(Inventory inventory) throws SQLException,
			IOException {
		PreparedStatement prepareStatement = connection
				.prepareStatement("insert into bookData values(?,?,?,?,?)");
		prepareStatement.setInt(1, inventory.getId());
		prepareStatement.setString(2, inventory.getTitle());
		prepareStatement.setString(3, inventory.getWriter());
		prepareStatement.setString(4, inventory.getPublisher());
		prepareStatement.setString(5, inventory.getPublisherYear());
		prepareStatement.executeUpdate();

	}

	/*
	 * Method to display all the information from the database
	 * @return list of inventory objects
	 */
	public ArrayList<Inventory> information() throws SQLException {
		statement = null;
		statement = (Statement) connection.createStatement();
		String strQuery = "SELECT * FROM bookdata";
		resultSet = statement.executeQuery(strQuery);
		ArrayList<Inventory> inventory = new ArrayList<Inventory>();
		while (resultSet.next()) {
			Inventory inventoryObject = new Inventory();
			inventoryObject.setTitle(resultSet.getString("Title"));
			inventoryObject.setId(Integer.parseInt(resultSet
					.getString("BookId")));
			inventoryObject.setPublisher(resultSet.getString("Publisher"));
			inventoryObject.setPublisherYear(resultSet
					.getString("PublishedYear"));
			inventoryObject.setWriter(resultSet.getString("Writer"));
			inventory.add(inventoryObject);
		}

		return inventory;
	}

	/*
	 * Method to retrieve a book by its title
	 * @return inventory object
	 */
	public ArrayList<Inventory> selectInformation(String title)
			throws SQLException {
		statement = null;
		statement = (Statement) connection.createStatement();
		String strQuery = "SELECT * FROM bookData where Title = '" + title
				+ "'";
		resultSet = statement.executeQuery(strQuery);
		ArrayList<Inventory> inventory = new ArrayList<Inventory>();
		while (resultSet.next()) {
			Inventory inventoryObject = new Inventory();
			inventoryObject.setTitle(resultSet.getString("Title"));
			inventoryObject.setId(Integer.parseInt(resultSet
					.getString("BookId")));
			inventoryObject.setPublisher(resultSet.getString("Publisher"));
			inventoryObject.setPublisherYear(resultSet
					.getString("PublishedYear"));
			inventoryObject.setWriter(resultSet.getString("Writer"));
			inventory.add(inventoryObject);
		}

		return inventory;
	}

	/*
	 * Method to update information of a book
	 */
	public void updateBook(Inventory inventory, String title)
			throws SQLException, IOException {
		PreparedStatement ps = connection
				.prepareStatement("update Book set BookId = ?, Title = ?, Writer = ?, Publisher = ?, PublishedYear = ?"
						+ "where Title = ?");
		ps.setInt(1, inventory.getId());
		ps.setString(2, inventory.getTitle());
		ps.setString(3, inventory.getWriter());
		ps.setString(4, inventory.getPublisher());
		ps.setString(5, inventory.getPublisherYear());
		ps.setString(6, title);
		ps.executeUpdate();
	}

	// Method to delete all books from the database.
	public void deleteAll() throws SQLException {
		PreparedStatement ps = connection
				.prepareStatement("delete from bookData");
		ps.executeUpdate();
	}

	// Method to delete a book by its id.
	public void deleteBook(int id) throws SQLException {
		PreparedStatement ps = connection
				.prepareStatement("delete from bookData where BookId = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public void close() throws SQLException {
		connection.close();
	}
}
