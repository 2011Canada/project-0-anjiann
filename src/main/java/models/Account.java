package models;

public class Account {
	private int accountId;
	private double balance;
	private String name;
	private int status;
	
	public Account(String name, int accountId, double balance) {
		this(name, accountId, balance, 0);
	}
	
	public Account(String name, int accountId, double balance, int status) {
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
		this.status = status;
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
	
	public int getStatus() {
		return status;
	}
}
