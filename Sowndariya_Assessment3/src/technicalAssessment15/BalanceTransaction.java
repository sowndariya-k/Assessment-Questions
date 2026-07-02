package technicalAssessment15;

import java.util.Scanner;

abstract class BankTransactionException extends Exception {
	int code;

	BankTransactionException(String message, int code) {
		super(message);
		this.code = code;
	}
}

class InvalidAccountException extends BankTransactionException {
	public InvalidAccountException(String message) {
		super(message, 1001);
	}
}

class InsufficientFundsException extends BankTransactionException {

	public InsufficientFundsException(String message) {
		super(message, 1002);
	}
}

class TransactionLimitException extends BankTransactionException {
	TransactionLimitException(String message) {
		super(message, 1003);
	}
}

class TransactionValidator {
	static void validate(String accountId, double balance, double amount, double limit)
			throws BankTransactionException {

		if (accountId == null || accountId.isEmpty())
			throw new InvalidAccountException("Account ID cannot be empty");

		if (amount > balance)
			throw new InsufficientFundsException("Shortfall: " + (amount - balance));

		if (amount > limit)
			throw new TransactionLimitException("Limit: " + limit);
	}
}

public class BalanceTransaction {
	public static void main(String[] args) throws BankTransactionException {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter Account ID: ");
		String accountId = input.nextLine();

		System.out.print("Enter Balance: ");
		double balance = input.nextDouble();

		System.out.print("Enter Withdraw Amount: ");
		double amount = input.nextDouble();

		System.out.print("Enter Daily Limit: ");
		double limit = input.nextDouble();

		try {
			TransactionValidator.validate(accountId, balance, amount, limit);
			System.out.println("Transaction is valid.");

		} catch (InvalidAccountException e) {
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage() + " [Code: " + e.code + "]");
		} catch (InsufficientFundsException e) {
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage() + " [Code: " + e.code + "]");
		} catch (TransactionLimitException e) {
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage() + " [Code: " + e.code + "]");
		} finally {
			System.out.println("Validation complete.");
		}

		input.close();
	}
}