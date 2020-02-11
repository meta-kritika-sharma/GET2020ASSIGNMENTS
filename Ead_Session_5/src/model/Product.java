package model;

public class Product{

	private int productCode;
	private String productType;
	private String productName;
	private double productPrice;
	private int productQuantity;
	/**
	 * Instantiates a new product.
	 *
	 * @param productCode the product code
	 * @param productName the product name
	 * @param productType the product type
	 * @param productPrice the product price
	 */

	public Product(int productCode, String productName, String productType, double productPrice, int productQuantity) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	//Getters methods
	public int getProductCode(){
		return productCode;	
	}
  
	public String getProductType(){
		return productType;
	}
 	 
	public String getProductName(){
		return productName;
	}
 
	public double getProductPrice(){
		return productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}
}
