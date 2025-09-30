package com.ryg.financetracker.controller;

import com.ryg.financetracker.model.CategoryDto;
import com.ryg.financetracker.service.CategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

  private final CategoriesService categoriesService;

  public CategoriesController(CategoriesService categoriesService) {
    this.categoriesService = categoriesService;
  }

  @GetMapping
  public Flux<CategoryDto> getAllCategories() {
    return categoriesService.getAllCategories();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
    return categoriesService.addCategory(categoryDto)
      .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create category")));
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> deleteCategory(@PathVariable Integer id) {
    return categoriesService.deleteCategory(id)
      .map(success -> success
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build());
  }
}