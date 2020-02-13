/* @author - Kritika Sharma
 * @date - 11-02-2020
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Product;
import model.cart;
import controller.ProductController;

/**
 * The Class MainView.
 */
public class MainView {

	static Scanner sc = new Scanner(System.in);
	static ProductController controller = new ProductController();

	public static void main(String[] args){
		userChoice();	
	}

	/**
	 * Method to show validation fields.
	 * @return user id
	 * @throws SQLException
	 * @throws exception if user does not exist.
	 */
	private static int authentication() throws SQLException, Exception{
		System.out.println("Enter mail-id");
		String mail = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		int id = controller.validateUser(mail, password);
		return id; 
	}

	/**
	 * Method to display products available.
	 * @throws SQLException the SQL exception
	 * @throws Exception
	 */
	private static void showProducts() throws SQLException, Exception {
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts = controller.showProducts();
		int id = 0;
		System.out.println("\nList of products available : ");
		for(Product product : listOfProducts)
		{
			System.out.println("Product " + (++id));
			System.out.println("\tProduct Name : " + product.getProductName());
			System.out.println("\tProduct Type : " + product.getProductType());
			System.out.println("\tProduct Price : " + product.getProductPrice());
			System.out.println("\tProduct Quantity : " + product.getProductQuantity());
		}
	}

	/**
	 * Method to display choices available for the user.
	 */
	private static void showChoices(){
		System.out.println("\n1. Add a product to cart.");
		System.out.println("2. Show cart.");
		System.out.println("3. Update quantity in cart.");
		System.out.println("4. Delete Product from Cart.");
		System.out.println("5. Exit");
		System.out.print("\nEnter your choice : ");
	}

	/**
	 * Method to call various functions depending upon user choice.
	 */
	private static void userChoice(){
		int flag=1;
		while(flag==1){
			try{
				int userId = MainView.authentication();
				if (userId>0){
					int productId, quantity,userChoice;
					while(true){
						try{
							MainView.showChoices();
							userChoice = sc.nextInt();

							if (userChoice == 1){
								MainView.showProducts();
								System.out.println("Enter productId");
								productId = sc.nextInt();
								System.out.println("Enter quantity");
								quantity = sc.nextInt();
								controller.addProductToCart(productId, userId, quantity);
							}

							else if (userChoice == 2){
								List<cart> listOfCartItems = controller.showCart(userId);
								System.out.println("Cart contents.");
								for(cart cartItem : listOfCartItems)
								{
									System.out.println("\tProduct Id : " + cartItem.getProductId());
									System.out.println("\tProduct Quantity : " + cartItem.getQuantity());
								}
							}
							
							else if (userChoice == 3){
								controller.showCart(userId);
								System.out.println("Enter productId");
								productId = sc.nextInt();
								System.out.println("Enter quantity");
								quantity = sc.nextInt();
								controller.editProduct(userId, productId, quantity);
							}
							
							else if (userChoice == 4){
								System.out.println("Enter productId");
								productId = sc.nextInt();
								controller.deleteProduct(userId, productId);
							}
							
							else if (userChoice == 5){
								flag = 0;
								System.out.println("Thanks for using");
								break;
							}
							else{
								System.out.println("Invalid choice");
							}
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
					}
				}
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
