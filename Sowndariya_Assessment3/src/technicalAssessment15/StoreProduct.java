package technicalAssessment15;

import java.util.*;

//comparable used
class Product implements Comparable<Product> {
	int productId;
	String productName;
	String productCategory;
	double productPrice;
	double productDiscount;
	int productQuantity;

	public Product(int id, String name, String category, double price, double discount, int quantity) {
		this.productId = id;
		this.productName = name;
		this.productCategory = category;
		this.productPrice = price;
		this.productDiscount = discount;
		this.productQuantity = quantity;
	}

	@Override
	public int compareTo(Product p) {
		return this.productId - p.productId;
	}

	public void display() {
		System.out.println(productId + " | " + productName + " | " + productCategory + " | " + productPrice + " | "
				+ productDiscount + " | " + productQuantity);
	}
}

public class StoreProduct {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Product> products = new ArrayList<>();

		products.add(new Product(101, "iphone10", "Mobile", 20000, 0.2, 2));
		products.add(new Product(102, "Dell", "Laptop", 20000, 0.3, 4));
		products.add(new Product(103, "iphone13", "Mobile", 10000, 0.5, 1));
		products.add(new Product(104, "Lenovo", "Laptop", 70000, 0.8, 3));
		products.add(new Product(105, "iphone12", "Mobile", 50000, 0.5, 6));

		while (true) {
			System.out.println("\n1. Sort by Id");
			System.out.println("2. List Mobiles with price more than 40000");
			System.out.println("3. Exit\n");
			System.out.print("Enter the option for sorting:");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				Collections.sort(products);
				for (Product p : products) {
					p.display();
				}
				break;

			case 2:
				boolean found = false;
				for (Product p : products) {
					if (p.productCategory.equalsIgnoreCase("Mobile") && p.productPrice > 40000) {
						p.display();
						found = true;
					}
				}
				if (!found) {
					System.out.println("No mobiles found above 40000");
				}
				break;

			case 3:
				System.out.println("Thank you!!");
				sc.close();
				return;

			default:
				System.out.println("Invalid choice");
			}
		}
	}

}
