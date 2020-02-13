package model;

public class cart{
	
	private int cartId;
	private int userId;
	private int productId;
	private int quantity;
	
	/**
	 * Instantiates a new cart.
	 *
	 * @param cartId the cart id
	 * @param userId the user id
	 * @param productId the product id
	 * @param quantity the quantity
	 */
	public cart(int cartId, int userId, int productId, int quantity){
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}
 
	//getter methods
	public int getUserId(){
		return userId;
	}
 
	public int getCartId(){
		return cartId;
	}
	
 	public int getProductId(){
		return productId;
	}
	
 	public int getQuantity(){
		return quantity;
	}
}
