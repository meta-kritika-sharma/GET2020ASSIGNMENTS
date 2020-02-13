package dao;

import java.sql.SQLException;
import java.util.List;
import model.Product;
import model.cart;

/**
 * The Interface BaseDao.
 */
public interface BaseDao {

	/**
	 * Method to Validate user.
	 *
	 * @param query the query to be executed
	 * @return the id of user
	 * @throws SQLException the SQL exception
	 * @throws Exception when user credentials are invalid.
	 */
	public int validateUser(String query) throws SQLException, Exception;
	
	/**
	 * Method to display the list of products.
	 *
	 * @param query the query to be executed
	 * @return the list of products available
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public List<Product> showProducts(String query) throws SQLException, Exception;
	
	/**
	 * Adds the product to cart.
	 *
	 * @param query the query to be executed
	 * @param ProductId the product id
	 * @param quantity the quantity
	 * @return true if successfully added.
	 * @throws SQLException the SQL exception
	 * @throws Exception.
	 */
	public Boolean addProductToCart(String query, int ProductId, int quantity) throws SQLException, Exception;
	
	/**
	 * Show cart.
	 *
	 * @param query the query to be executed
	 * @return the list of cart items
	 * @throws SQLException the SQL exception
	 * @throws Exception if cart is empty.
	 */
	public List<cart> showCart(String query) throws SQLException, Exception;
	
	/**
	 * Method to Edit the product.
	 *
	 * @param the query to be executed
	 * @return true if successfully editted.
	 * @throws SQLException the SQL exception
	 * @throws Exception
	 */
	public Boolean editProduct(String query) throws SQLException, Exception;
	
	/**
	 * Method to Delete product.
	 *
	 * @param query the query to be executed
	 * @param ProductId the product id
	 * @return true if product successfully deleted
	 * @throws SQLException the SQL exception
	 * @throws Exception if product does not exist in cart.
	 */
	public Boolean deleteProduct(String query,int ProductId) throws SQLException, Exception;
}
