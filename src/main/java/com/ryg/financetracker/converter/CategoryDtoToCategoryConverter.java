package com.ryg.financetracker.converter;

import com.ryg.financetracker.model.CategoryDto;
import com.ryg.financetracker.model.table.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoToCategoryConverter implements Converter<CategoryDto, Category> {

  @Override
  public Category convert(@NotNull CategoryDto source) {
    try {
      Category category = new Category();
      category.setCategoryName(source.getCategoryName());
      return category;
    } catch (final IllegalArgumentException exception) {
      return null;
    }
  }
}
