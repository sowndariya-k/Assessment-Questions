package oopsConcepts;

import java.util.*;

class Customer {
	int id;
	String name;
	char gender;

	public Customer(int id, String name, char gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return name + "(" + id + ")";
	}

}

class Account {
	int id;
	Customer customer;
	static double balance;

	public Account(int id, Customer customer, double balance) {
		this.customer = customer;
		this.balance = balance;
	}

	public Account(int id, Customer customer) {
		this.id = id;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return customer.toString() + ", balance=$" + String.format("%.2f", balance);
	}

	public static void deposit(double amount) {
		balance += amount;
		System.out.println("Amount deposit successful");
	}

	public static void withdraw(double amount) {
		if (balance >= amount) {
			balance -= amount;
			System.out.println("Amount withdraw successful");
		} else {
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}

}

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ACCOUNT DETAILS");
		System.out.print("ACCOUNT_ID        : ");
		int id = sc.nextInt();
		System.out.println(id);

		System.out.print("CUSTOMER_ID     : ");
		int customerId = sc.nextInt();
		sc.nextLine();
		System.out.println(customerId);

		System.out.print("CUSTOMER_NAME     : ");
		String name = sc.nextLine();
		System.out.println(name);

		System.out.print("CUSTOMER_GENDER   : ");
		char gender = sc.next().charAt(0);
		System.out.println(gender);
		
		
		System.out.print("ACCOUNT_BALANCE : ");
		double balance = sc.nextDouble();
		System.out.println(balance);
		Account.balance = balance;
		
		int option = 0;
		while(option!=4) {
		System.out.println("PLEASE SELECT ONE OPTION FROM BELOW");
		System.out.println("1.WITHDRAW\n 2. DEPOSIT\n 3. CHECK BALANCE\n 4. EXIT\n");
		
			System.out.print("OPTION: ");
			option = sc.nextInt();
			System.out.println(option);
		switch (option) {
		case 1:
			System.out.print("ENTER AMOUNT TO WITHDRAW: ");
			double amount = sc.nextDouble();
			System.out.println(amount);
			Account.withdraw(amount);
			break;

		case 2:
			System.out.print("ENTER AMOUNT TO DEPOSIT: ");
			double amountD = sc.nextDouble();
			System.out.println(amountD);
			Account.deposit(amountD);
			break;

		case 3:
			System.out.println("CURRENT BALANCE: " + Account.balance);
			break;

		case 4:
			System.out.println("THANK YOU FOR BANKING WITH US!!");
			break;
		}
		}

	}

}
