package com.bankapp.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	private String type;
	private int fromAcc;
	private int toAcc;
	private String transDetails;
	private LocalDateTime timestamp;
	private String status;

	public TransactionLog() {
	}

	public TransactionLog(String type, int fromAcc, int toAcc, String transDetails) {
		this.type = type;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.transDetails = transDetails;
		this.timestamp = LocalDateTime.now();
		this.status = "success";
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getToAcc() {
		return toAcc;
	}

	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransDetails() {
		return transDetails;
	}

	public void setTransDetails(String transDetails) {
		this.transDetails = transDetails;
	}

	@Override
	public String toString() {
		return "TransactionLog [transId=" + transId + ", type=" + type + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc
				+ ", transDetails=" + transDetails + ", timestamp=" + timestamp + ", status=" + status + "]";
	}

}
