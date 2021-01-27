package com.bankapp.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account_details")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accId;
	private double balance;
	private LocalDate accountCreationDate;
	private String accountType;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String password;
	private LocalDate dob;

	@JsonIgnore
	@JoinColumn(name = "accId_fk", nullable = false)
	@OneToMany(cascade = CascadeType.ALL)
	private List<TransactionLog> transLog = new ArrayList<>();

	public Account() {
	}

	public Account(double balance, String accountType, String name, String address, String phone, String email,
			String password, LocalDate dob) {
		this.balance = balance;
		this.accountCreationDate = LocalDate.now();
		this.accountType = accountType;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public List<TransactionLog> getTransLog() {
		return transLog;
	}

	public void setTransLog(List<TransactionLog> transLog) {
		this.transLog = transLog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Account [accId=" + accId + ", balance=" + balance + ", accountCreationDate=" + accountCreationDate
				+ ", accountType=" + accountType + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", dob=" + dob + ", transLog=" + transLog + "]";
	}

}
