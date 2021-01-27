package com.bankapp.dto;

public class WithdrawAmount {
	private int accountId;
	private double amount;

	public WithdrawAmount() {
	}

	public WithdrawAmount(int accountId, double amount) {
		super();
		this.accountId = accountId;
		this.amount = amount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
