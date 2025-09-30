package com.ryg.financetracker.model;

import org.springframework.data.annotation.Id;

public class CategoryDto {
  @Id private Integer id;

  private String categoryName;

  public CategoryDto() {}

  public CategoryDto(Integer id, String categoryName) {
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
