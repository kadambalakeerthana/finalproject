package com.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.TransactionLog;

@Repository
public interface TransactionLogRepo extends JpaRepository<TransactionLog, Integer> {

}
