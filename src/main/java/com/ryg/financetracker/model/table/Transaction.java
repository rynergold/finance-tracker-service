package com.ryg.financetracker.model.table;

import com.ryg.financetracker.model.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("finances")
public class Transaction {

  @Id
  @Column("id")
  private Integer id;

  @Column("transaction_date")
  private LocalDate transactionDate;

  @Column("transaction_type")
  private TransactionType transactionType;

  @Column("category_id")
  private Integer categoryId;

  @Column("amount")
  private BigDecimal amount;

  @Column("description")
  private String description;

  public Transaction() {}

  public Integer getId() {
    return id;
  }

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
