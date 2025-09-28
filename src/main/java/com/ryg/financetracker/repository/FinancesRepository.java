package com.ryg.financetracker.repository;

import com.ryg.financetracker.model.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancesRepository extends ReactiveCrudRepository<Transaction, Integer> {

}
