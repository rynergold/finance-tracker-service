package com.ryg.financetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("finances")
public class Finances {

    @Id
    @Column("id")
    private Integer id;

    @Column("transaction_date")
    private LocalDate transactionDate;

    @Column("transaction_type")
    private TransactionType transactionType;

    @Column("category")
    private String category;

    @Column("amount")
    private BigDecimal amount;

    @Column("description")
    private String description;

    public Finances() {}

    public Integer getId() {
        return id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
