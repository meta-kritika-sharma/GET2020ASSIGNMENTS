
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.Product;
import model.cart;

public class ProductDao implements BaseDao{

	Connection connection;

	public ProductDao(){
		connection = DbConnection.createConnection();
	}

	/**
	 * Method to Validate user.
	 *
	 * @param query the query to be executed
	 * @return the id of user
	 * @throws SQLException the SQL exception
	 * @throws Exception when user credentials are invalid.
	 */

	@Override
	public int validateUser(String query) throws Exception {

		ResultSet resultTable = executePrepareQuery(query);
		if (resultTable.next()){
			int id = resultTable.getInt("UserId");
			return id;
		}
		throw new Exception ("Invalid Credentials.");
	}

	/**
	 * Method to display the list of products.
	 *
	 * @param query the query to be executed
	 * @return the list of products available
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */

	@Override
	public List<Product> showProducts(String query) throws Exception {

		List<Product> listOfProducts = new ArrayList<>();
		ResultSet resultTable = executePrepareQuery(query);
		while(resultTable.next()){
			listOfProducts.add(new Product(resultTable.getInt("ProductId"),resultTable.getString("ProductName"), resultTable.getString("ProductType"), resultTable.getDouble("ProductPrice"),resultTable.getInt("ProductQuantity")));
		}

		return listOfProducts;
	}

	/**
	 * Adds the product to cart.
	 *
	 * @param query the query to be executed
	 * @param ProductId the product id
	 * @param quantity the quantity to be added
	 * @return true if successfully added, false otherwise.
	 * @throws SQLException the SQL exception
	 * @throws Exception.
	 */

	@Override
	public Boolean addProductToCart(String query, int ProductId, int quantity) throws Exception {

		String sqlQuery = "select ProductId from product;";
		ResultSet result = executePrepareQuery(sqlQuery);
		int flag =0;
		
		//checking whether the entered product is available for addition.
		while (result.next()){
			if (ProductId == result.getInt("ProductId")){
				flag =1;
				break;
			}
		}
		if (flag ==0){
			throw new Exception ("Product does not exist");
		}
		
		// checking if products are available in stock for addition.
		sqlQuery = "select ProductQuantity from product where ProductId = "+ProductId+";";
		result = executePrepareQuery(sqlQuery);
		result.next();
		int updatedQuantity = result.getInt("ProductQuantity");
		if (updatedQuantity < quantity ){
			throw new Exception ("Not enough products available");
		}
		
		//checking if a product has already been added to the cart.
		sqlQuery = "select count(*) as count from cart where ProductId="+ProductId;
		result = executePrepareQuery(sqlQuery);
		result.next();
		System.out.println(result.getInt("count"));
		if (result.getInt("count")>0){
			sqlQuery = "select ProductQuantity from cart where ProductId="+ProductId;
			result = executePrepareQuery(sqlQuery);
			result.next();
			int cartQuantity = result.getInt("ProductQuantity")+quantity;
			sqlQuery = "update cart set ProductQuantity="+cartQuantity+" where ProductId="+ProductId;
			if (executeUpdateQuery(sqlQuery)<0){
				return false;
			}
		}
		else{
			 if (executeUpdateQuery(query)<0){
				return false; 
			 }
		}
		sqlQuery = "update product set ProductQuantity = "+(updatedQuantity-quantity)+" where ProductId= "+ProductId+";";
		if (executeUpdateQuery(sqlQuery)<0){
			return false;
		}
		return true;
	}

	/**
	 * Method to display cart contents.
	 *
	 * @param query the query to be executed
	 * @return the list of cart items
	 * @throws SQLException the SQL exception
	 * @throws Exception if cart is empty.
	 */

	@Override
	public List<cart> showCart(String query) throws Exception {
		List<cart> listOfCartItems = new ArrayList<>();
		ResultSet resultTable = executePrepareQuery(query);
		while(resultTable.next()){
			listOfCartItems.add(new cart(resultTable.getInt("Cart_id"),resultTable.getInt("UserId"), resultTable.getInt("ProductId"), resultTable.getInt("ProductQuantity")));
		}
		if (listOfCartItems.size()>0){
			return listOfCartItems;}
		else{
			throw new Exception ("Cart is empty");
		}
	}

	/**
	 * Method to Edit the product quantity.
	 * @param the query to be executed
	 * @return true if successfully editted.
	 * @throws SQLException the SQL exception
	 * @throws Exception
	 */

	@Override
	public Boolean editProduct(String query) throws SQLException {
		if (executeUpdateQuery(query)>0){
			return true;
		}
		return false;
	}


	/**
	 * Method to Delete product.
	 *
	 * @param query the query to be executed
	 * @param ProductId the product id
	 * @return true if product successfully deleted
	 * @throws SQLException the SQL exception
	 * @throws Exception if product does not exist in cart.
	 */
	@Override
	public Boolean deleteProduct(String query, int ProductId) throws SQLException {
		
		String selectQuantityQuery = "select ProductQuantity from product where ProductId = "+ProductId+";";
		ResultSet result = executePrepareQuery(selectQuantityQuery);
		result.next();
		int updatedQuantity = result.getInt("ProductQuantity");
		String updateQuantityQuery = "update product set ProductQuantity = "+(updatedQuantity+1)+" where ProductId= "+ProductId+";";
		if (executeUpdateQuery(updateQuantityQuery)<0){
			return false;
		}
		if (executeUpdateQuery(query)<0){
			return false;
		}
		return true;
	}

	//helper function to execute query
	private ResultSet executePrepareQuery(String query) throws SQLException{
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		ResultSet resultTable = statement.executeQuery();
		return resultTable;
	}

	//helper function to execute query
	private int executeUpdateQuery(String query) throws SQLException{
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(query);
		return statement.executeUpdate();
	}
}
