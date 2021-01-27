package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.AccountRepo;
import com.bankapp.dao.TransactionLogRepo;
import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;
import com.bankapp.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountRepo accountRepo;
	private TransactionLogRepo transLogRepo;

	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo, TransactionLogRepo transLogRepo) {
		this.accountRepo = accountRepo;
		this.transLogRepo = transLogRepo;
	}

	@Override
	public List<Account> getAllAcounts() {
		return (List<Account>) accountRepo.findAll();
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account with id " + accountId + "not found"));
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

	@Override
	public Account updateAccount(int accountId, Account account) {
		Account accToUpdate = getAccountById(accountId);
		accToUpdate.setAddress(account.getAddress());
		accToUpdate.setDob(account.getDob());
		accToUpdate.setEmail(account.getEmail());
		accToUpdate.setPhone(account.getPhone());
		return accountRepo.save(accToUpdate);
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account accToDelete = getAccountById(accountId);
		accountRepo.delete(accToDelete);
		return accToDelete;
	}

	@Override
	public void transfer(int fromId, int toId, double amount) {
		Account fromAcc = getAccountById(fromId);
		Account toAcc = getAccountById(toId);
		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		TransactionLog fromAccLog = new TransactionLog("withdraw", fromId, toId, "withdraw");
		fromAcc.getTransLog().add(fromAccLog);

		TransactionLog toAccLog = new TransactionLog("deposit", fromId, toId, "deposit");
		toAcc.getTransLog().add(toAccLog);

		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account toDeposit = getAccountById(accountId);
		toDeposit.setBalance(toDeposit.getBalance() + amount);
		TransactionLog accLog = new TransactionLog("deposit", 0, accountId, "deposit");
		toDeposit.getTransLog().add(accLog);
		accountRepo.save(toDeposit);
	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account toWithdraw = getAccountById(accountId);
		toWithdraw.setBalance(toWithdraw.getBalance() - amount);
		TransactionLog accLog = new TransactionLog("withdraw", accountId, 0, "withdraw");
		toWithdraw.getTransLog().add(accLog);
		accountRepo.save(toWithdraw);
	}

	@Override
	public List<TransactionLog> getAllTransactions() {
		return transLogRepo.findAll();
	}

}
