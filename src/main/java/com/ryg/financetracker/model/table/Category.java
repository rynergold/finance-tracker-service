package com.ryg.financetracker.model.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("categories")
public class Category {
  @Id
  @Column("id")
  private Integer id;

  @Column("name")
  private String categoryName;

  public Category() {}

  public Category(Integer id, String categoryName) {
    this.id = id;
    this.categoryName = categoryName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
