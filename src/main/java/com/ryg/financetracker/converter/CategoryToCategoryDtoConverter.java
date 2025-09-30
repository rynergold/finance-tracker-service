package com.ryg.financetracker.converter;

import com.ryg.financetracker.model.CategoryDto;
import com.ryg.financetracker.model.table.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDtoConverter implements Converter<Category, CategoryDto> {

  @Override
  public CategoryDto convert(@NotNull Category source) {
    try {
      return new CategoryDto(
        source.getId(),
        source.getCategoryName()
      );
    } catch (final IllegalArgumentException exception) {
      return null;
    }
  }
}
