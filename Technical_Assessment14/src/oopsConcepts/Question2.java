package oopsConcepts;

import java.util.*;

abstract class Product{
	int productId;
	String productName;
	double price;
	
	public Product(int productId, String productName, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}
	public abstract void  displayInfo();
}


class ElectronicProduct extends Product{
	int warrentyPeriod;

	public ElectronicProduct(int productId, String productName, double price, int warrentyPeriod) {
		super(productId, productName, price);
		this.warrentyPeriod=warrentyPeriod;
	}
	
	public int getWarrentyPeriod() {
		return warrentyPeriod;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("ELECTRONIC PRODUCT INFORMATION:");
		System.out.println("ProductId : "+productId);
		System.out.println("ProductName: "+productName);
		System.out.println("Price :$ "+String.format("%.1f", price));
		System.out.println("Warrenty Period : "+warrentyPeriod+" Months");
	}	
	
}
class ClothingProduct extends Product{
	String size;
	String material;
	
	
	
	public ClothingProduct(int productId, String productName, double price, String size, String material) {
		super(productId, productName, price);
		this.size=size;
		this.material=material;
	}



	@Override
	public void displayInfo() {
		System.out.println("CLOTHING PRODUCT INFORMATION:");
		System.out.println("ProductId : "+productId);
		System.out.println("ProductName: "+productName);
		System.out.println("Price :$ "+String.format("%.1f", price));
		System.out.println("Size : "+size);
		System.out.println("Material :"+material);
	}	
}
public class Question2 {

	public static void main(String[] args) {
		Product product=new ElectronicProduct(201, "Laptop", 1200.0, 12);
		product.displayInfo();
		Product product2=new ClothingProduct(301, "T-shirt", 25.0, "m", "cotton");
		product2.displayInfo();
	}

}
