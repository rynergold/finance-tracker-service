package com.ryg.financetracker.service;

import com.ryg.financetracker.model.CategoryDto;
import com.ryg.financetracker.model.table.Category;
import com.ryg.financetracker.repository.CategoriesRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriesService {

  private CategoriesRepository categoriesRepository;
  private ConversionService conversionService;

  public CategoriesService(CategoriesRepository categoriesRepository, ConversionService conversionService) {
    this.categoriesRepository = categoriesRepository;
    this.conversionService = conversionService;
  }

  public Flux<CategoryDto> getAllCategories() {
    return categoriesRepository.findAll()
      .mapNotNull(category -> conversionService.convert(category, CategoryDto.class));
  }

  public Mono<CategoryDto> addCategory(CategoryDto categoryDto) {
    return Mono.defer(() ->
        Mono.justOrEmpty(conversionService.convert(categoryDto, Category.class)))
      .flatMap(categoriesRepository::save)
      .mapNotNull(savedCategory -> conversionService.convert(savedCategory, CategoryDto.class));
  }

  public Mono<Boolean> deleteCategory(Integer id) {
    return categoriesRepository.existsById(id)
      .flatMap(exists -> {
        if (exists) {
          return categoriesRepository.deleteById(id).thenReturn(true);
        } else {
          return Mono.just(false);
        }
      })
      .onErrorReturn(false);
  }
}

