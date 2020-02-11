package facade;

import java.sql.SQLException;
import java.util.List;
import model.Product;
import model.cart;
import dao.ProductDao;

/**
 * The Class ProductFacade.
 */
public class ProductFacade {
	ProductDao dao = new ProductDao();

	
	/**
	 * Validate user.
	 *
	 * @param mail the mail
	 * @param password the password
	 * @return the id of user
	 * @throws Exception if fields are empty.
	 */
	public int validateUser(String mail, String password) throws Exception {
		
		if ((mail.length()==0)||(password.length()==0)||(mail.equals(" "))||(password.equals(" "))){
			throw new Exception("Fields can't be empty");
		}
		String query = "select UserId from users where User_Name = '"+ mail + "' and Password = '" + password+"';";
		return dao.validateUser(query);
	}

	/**
	 * display the list of products available.
	 *
	 * @return the list of products
	 * @throws Exception
	 */
	public List<Product> showProducts() throws Exception {
		String query = "select * from product";
		return dao.showProducts(query);
	}

	/**
	 * Adds the product to cart.
	 *
	 * @param productId the product id
	 * @param userId the user id
	 * @param quantity the quantity to be added
	 * @return true if item added suceessfully , false otherwise.
	 * @throws Exception if quantity is invalid
	 */
	public Boolean addProductToCart(int productId, int userId, int quantity) throws Exception {
		
		if (quantity <0){
			throw new Exception ("Invalid quantity");
		}
		
		String query = "insert into cart (ProductId, UserId, ProductQuantity) values("+productId+","+userId+","+quantity+");";
		return dao.addProductToCart(query,productId,quantity);
	}

	/**
	 * Show cart.
	 *
	 * @param userId the user id
	 * @return the list of cart contents
	 * @throws Exception the exception
	 */
	public List<cart> showCart(int userId) throws Exception {
		String query = "select * from cart where UserId = "+userId+";";
		return dao.showCart(query);
	}

	/**
	 * Edits the product.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @param quantity the quantity
	 * @return true if editted successfully.
	 * @throws SQLException the SQL exception
	 */
	public Boolean editProduct(int userId, int productId, int quantity) throws SQLException {
		String query = "update cart set ProductQuantity = "+quantity+" where UserId = "+userId+" and ProductId= "+productId;
		return dao.editProduct(query);
	}

	/**
	 * Delete product.
	 *
	 * @param userId the user id
	 * @param productId the product id
	 * @return true if deleted successfully.
	 * @throws Exception the exception
	 */
	public Boolean deleteProduct(int userId, int productId) throws Exception {
		showCart(userId);
		String query = "delete from cart where UserId = " +userId+" and ProductId = "+productId;
		return dao.deleteProduct(query, productId);
	}

}
