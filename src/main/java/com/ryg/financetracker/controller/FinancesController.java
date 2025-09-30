package com.ryg.financetracker.controller;

import com.ryg.financetracker.model.TransactionDto;
import com.ryg.financetracker.service.FinancesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class FinancesController {

  private final FinancesService financesService;

  public FinancesController(FinancesService financesService) {
    this.financesService = financesService;
  }

  @GetMapping
  public Flux<TransactionDto> getTransactions() {
    return financesService.getAllTransactions();
  }

  @PostMapping
  public Mono<ResponseEntity<Void>> addTransaction(@RequestBody TransactionDto dto) {
    return financesService.addTransaction(dto)
      .map(success -> success
        ? ResponseEntity.status(HttpStatus.CREATED).build()
        : ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
  }

  @PutMapping("/{id}")
  public Mono<ResponseEntity<Void>> updateTransaction(
    @PathVariable Integer id,
    @RequestBody TransactionDto dto) {
    return financesService.updateTransaction(id, dto)
      .map(success -> success
        ? ResponseEntity.ok().build()
        : ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> deleteTransaction(@PathVariable Integer id) {
    return financesService.deleteTransaction(id)
      .map(success -> success
        ? ResponseEntity.noContent().build()
        : ResponseEntity.notFound().build());
  }

  @DeleteMapping
  public Mono<ResponseEntity<Void>> deleteTransactions(
    @RequestParam List<Integer> ids) {
    return Flux.fromIterable(ids)
      .flatMap(financesService::deleteTransaction)
      .then(Mono.just(ResponseEntity.noContent().build()));
  }
}