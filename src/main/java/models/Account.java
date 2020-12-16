package models;

public class Account {
	private int accountId;
	private double balance;
	private String name;
	
	public Account(String name, int accountId, double balance) {
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public double getBalance() {
		return balance;
	}
	
	public String getName() {
		return name;
	}
}
