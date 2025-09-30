package com.ryg.financetracker.repository;

import com.ryg.financetracker.model.table.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends ReactiveCrudRepository<Category, Integer> {

}
