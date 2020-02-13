package controller;
import java.sql.SQLException;
import java.util.List;
import model.Product;
import model.cart;
import facade.ProductFacade;

/**
 * The Class ProductController.
 */
public class ProductController {

	ProductFacade facade = new ProductFacade();
	
	/**
	 * Validate user.
	 *
	 * @param mail the mail
	 * @param password the password
	 * @return the user id
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public int validateUser(String mail, String password) throws SQLException, Exception{
		return facade.validateUser(mail, password);
	}
	
	/**
	 * Show products.
	 *
	 * @return the list of products available
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public List<Product> showProducts() throws SQLException, Exception{
		return facade.showProducts();
	}
	
	/**
	 * Adds the product to cart.
	 *
	 * @param productId the product id
	 * @param userId the user id
	 * @param quantity the quantity
	 * @return true if added successfully.
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public Boolean addProductToCart(int productId, int userId, int quantity) throws SQLException, Exception{
		return facade.addProductToCart(productId, userId, quantity);
	}
	
	/**
	 * Show cart.
	 *
	 * @param userId the user id
	 * @return the list of cart contents
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public List<cart> showCart(int userId) throws SQLException, Exception{
		return facade.showCart(userId);
	}
	
	/**
	 * Edits the product.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @param quantity the quantity
	 * @return true if editted successfully
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public Boolean editProduct(int userId, int productId, int quantity) throws SQLException, Exception{
		return facade.editProduct(userId, productId, quantity);
	}
	
	/**
	 * Delete product.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @return true if deleted successfully.
	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public Boolean deleteProduct(int userId, int productId) throws SQLException, Exception{
		return facade.deleteProduct(userId, productId);
	}

	
	
}
