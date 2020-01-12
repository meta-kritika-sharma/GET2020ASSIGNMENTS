/*A program to implement the shopping cart class that involves a cart to store items. 
 The items can be updated and displayed as per requirements.*/
import java.util.*;
import java.lang.String;
class Item{
	String nameOfItem;
	int priceOfItem;
	public Item(String name, int price){
		nameOfItem = name;
		priceOfItem = price;
	}
	public void displayItem(){
		System.out.print("Item : "+nameOfItem+"\nPrice of 1 "+nameOfItem+" : "+priceOfItem);
	}
}

public class Cart {
	HashMap<Item, Integer> cartItems;
	int finalBillPrice;
	public Cart(){	//Initializer Block
		cartItems = new HashMap<>();
		finalBillPrice=0;	
	}
	public void addItem(Item item, int qty){
		/*This method is used to add item to the cart.
		 *@param item This is the item that is to be added to the cart
		 *@param qty This is the quantity of item to be added
		 *@return nothing
		*/
		if (cartItems.containsKey(item)){
		cartItems.put(item, cartItems.get(item)+qty);
		}
		else{
		cartItems.put(item,qty);	
		}
		finalBillPrice = finalBillPrice+ (qty*item.priceOfItem);
	}
	public void removeItem(Item item){
		/*This method is used to remove item from the cart.
		 *@param item This is the item that is to be added to the cart
		 *@return nothing
		*/
		if ((cartItems.containsKey(item)) && (cartItems.get(item)!=0)){
			cartItems.put(item, cartItems.get(item)-1); 	
		}
		finalBillPrice = finalBillPrice-item.priceOfItem;
	}
	public int displayBill(){
		return finalBillPrice;
	}
	public void displayCartContents(){
		if (cartItems.size()!=0){
			for (Map.Entry iterator: cartItems.entrySet()){
				Item item = (Item)iterator.getKey();
				Integer quantity = (Integer)iterator.getValue();
				item.displayItem();
				System.out.println("\nQuantity in your cart : "+quantity);
			}
		}
		else{
			System.out.println("No items to be displayed");
		}
	}
	
	public static void getUserChoice(Cart c){
		HashMap<String, Item> initialStock;
		initialStock = new HashMap<>();
		initialStock.put("BAG", new Item("BAG",500));
		initialStock.put("HEADPHONES", new Item("HEADPHONES",100));
		initialStock.put("MOBILECOVER", new Item("MOBILECOVER",50));
		initialStock.put("WATCH", new Item("WATCH",1000));
		initialStock.put("MOBILECHARGER", new Item("MOBILECHARGER",700));
		initialStock.put("POWERBANK", new Item("POWERBANK",1500));
		initialStock.put("WATERBOTTLE", new Item("WATERBOTTLE",150));
		System.out.println("The items available in the stock are :");
		for(String iterator :initialStock.keySet()){
			System.out.println(iterator+" "+initialStock.get(iterator).priceOfItem);
		}
		System.out.println("\n");
		int flag =0;
		System.out.println("Enter 1 to add item \nEnter 2 to remove item \nEnter 3 to display items \nEnter 4 to display bill \nEnter 5 to exit");
		while(flag==0){
			System.out.println("Ënter your choice : ");
			Scanner sc = new Scanner(System.in);
			int userChoice = 0;
			try{
				userChoice = sc.nextInt();
				if (userChoice==1){
					System.out.println("Enter name of the item :");
					sc.nextLine();
					String ItemName = sc.nextLine();
					ItemName = ItemName.replaceAll(" ","");
					//Checking the availability of item required in the stock.
					if (initialStock.containsKey(ItemName.toUpperCase())){
						System.out.println("Enter quanity:");
						int QuantityOfItem = sc.nextInt();
						c.addItem(initialStock.get(ItemName.toUpperCase()), QuantityOfItem);
						System.out.println(ItemName.toUpperCase()+" successfully added to the cart.");
					}
					else{
						System.out.println("Item not available in the stock.");
					}
				}
				else if (userChoice==2){
					System.out.println("Enter name of the item to be removed:");
					String ItemName = sc.next();
					if (initialStock.containsKey(ItemName.toUpperCase())){
						c.removeItem(initialStock.get(ItemName.toUpperCase()));
						System.out.println("One "+ItemName.toUpperCase()+" successfully removed from the cart.");
					}
					else{
						System.out.println("Item not available in the cart");
					}
				}
				else if (userChoice==3){
					System.out.println("Your Cart Contents:");
					c.displayCartContents();
				}
				else if (userChoice==4){
					System.out.println("Your total bill is "+c.displayBill());
				}
				else if (userChoice==5){
					System.out.println("Thanks for using.");
					flag=1;
				}
				else{
					System.out.println("Invalid Choice");
				}
			}
			catch(java.util.InputMismatchException e){
				System.out.println("Invalid Input. Please enter your choice again.");
			}
		}
	}
	public static void main(String args[]){
		Cart c = new Cart();
		getUserChoice(c);
	}
}
