package com.bankapp.service;

import java.util.List;

import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;

public interface AccountService {
	public List<Account> getAllAcounts();

	public Account getAccountById(int accountId);

	public Account addAccount(Account account);

	public Account updateAccount(int accountId, Account account);

	public Account deleteAccount(int accountId);

	public void transfer(int fromId, int toId, double amount);

	public void deposit(int accountId, double amount);

	public void withdraw(int accountId, double amount);

	public List<TransactionLog> getAllTransactions();
}
