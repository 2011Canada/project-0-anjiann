package models;

public class Transfer {
	private int srcAccountId;
	private int dstAccountId;
	private double amount;
	
	public Transfer(int srcAccountId, int dstAccountId, double amount) {
		this.srcAccountId = srcAccountId;
		this.dstAccountId = dstAccountId;
		this.amount = amount;
	}
	
	public int getSrcAccountId() {
		return srcAccountId;
	}

	public int getDstAccountId() {
		return dstAccountId;
	}

	public double getAmount() {
		return amount;
	}
}
