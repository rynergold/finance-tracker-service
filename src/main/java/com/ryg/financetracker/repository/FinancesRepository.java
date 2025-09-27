package com.ryg.financetracker.repository;

import com.ryg.financetracker.model.Finances;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancesRepository extends ReactiveCrudRepository<Finances, Integer> {

}
