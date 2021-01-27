package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dao.AuthResponse;
import com.bankapp.dto.DepositAmount;
import com.bankapp.dto.TransferAmount;
import com.bankapp.dto.WithdrawAmount;
import com.bankapp.entities.Account;
import com.bankapp.entities.TransactionLog;
import com.bankapp.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AccountRestController {

	@Autowired
	private AccountService accountService;

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public AuthResponse validateLogin() {
		return new AuthResponse("User successfully authenticated");
	}

	@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> allAccounts() {
		return accountService.getAllAcounts();
	}

	@GetMapping(path = "transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog> allTransactions() {
		return accountService.getAllTransactions();
	}

	@GetMapping(path = "account/{accId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account getAccountById(@PathVariable(name = "accId") int accId) {
		return accountService.getAccountById(accId);
	}

	@PostMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Account addNewAccount(@RequestBody Account account) {
		return accountService.addAccount(account);
	}

	@PutMapping(path = "account/{accId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Account updateAccount(@PathVariable(name = "accId") int accId, @RequestBody Account account) {
		return accountService.updateAccount(accId, account);

	}

	@DeleteMapping(path = "account/{accId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Account deleteAccount(@PathVariable(name = "accId") int accId) {
		return accountService.deleteAccount(accId);
	}

	@PostMapping(path = "acctransfer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String transferFund(@RequestBody TransferAmount transAmt) {
		accountService.transfer(transAmt.getFromId(), transAmt.getToId(), transAmt.getAmount());
		return "fund is transferred";
	}

	@PostMapping(path = "accdeposit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String depositFund(@RequestBody DepositAmount depositAmt) {
		accountService.deposit(depositAmt.getAccountId(), depositAmt.getAmount());
		return "amount deposited successfully";
	}

	@PostMapping(path = "accwithdraw", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String withdrawFund(@RequestBody WithdrawAmount withdrawAmt) {
		accountService.withdraw(withdrawAmt.getAccountId(), withdrawAmt.getAmount());
		return "amount withdrawl successfully";
	}
}
